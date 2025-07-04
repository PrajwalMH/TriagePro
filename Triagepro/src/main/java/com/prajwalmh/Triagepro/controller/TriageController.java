package com.prajwalmh.Triagepro.controller;

import com.prajwalmh.Triagepro.entity.TriageLog;
import com.prajwalmh.Triagepro.entity.User;
import com.prajwalmh.Triagepro.repositories.TriageLogRepository;
import com.prajwalmh.Triagepro.repositories.UserRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import com.prajwalmh.Triagepro.entity.Appointment;
import com.prajwalmh.Triagepro.repositories.AppointmentRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class TriageController {

    @Autowired
    private TriageLogRepository triageLogRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AppointmentRepository appointmentRepository;

    @PostMapping("/triage")
    public Map<String, Object> triage(@RequestBody SymptomRequest request) {
        String aiUrl = "http://localhost:5000/predict";

        // Prepare payload
        Map<String, String> payload = new HashMap<>();
        payload.put("symptoms", request.getSymptoms());

        // Call dummy AI microservice
        Map<String, String> aiResponse = restTemplate.postForObject(aiUrl, payload, Map.class);

        // Save to DB with dummy user id=1
        User patient = userRepository.findById(1L).orElse(null);

        TriageLog log = new TriageLog();
        log.setUser(patient);
        log.setSymptoms(request.getSymptoms());
        log.setPredictedDepartment(aiResponse.get("department"));
        log.setTriageLevel(aiResponse.get("triage_level"));
        log.setCreatedAt(LocalDateTime.now());
        triageLogRepository.save(log);

        // Build response to frontend
        Map<String, Object> response = new HashMap<>();
        response.put("department", aiResponse.get("department"));
        response.put("triageLevel", aiResponse.get("triage_level"));

        return response;
    }

    @GetMapping("/triage-logs")
    public List<Map<String, Object>> getTriageLogs() {
        List<TriageLog> logs = triageLogRepository.findAll();
        List<Map<String, Object>> response = new ArrayList<>();

        for (TriageLog log : logs) {
            Map<String, Object> entry = new HashMap<>();
            entry.put("id", log.getId());
            entry.put("symptoms", log.getSymptoms());
            entry.put("department", log.getPredictedDepartment());
            entry.put("triageLevel", log.getTriageLevel());
            entry.put("createdAt", log.getCreatedAt());
            response.add(entry);
        }
        return response;
    }

    @GetMapping("/doctors")
    public List<Map<String, Object>> getDoctors() {
        List<Map<String, Object>> doctors = new ArrayList<>();
        doctors.add(Map.of("id", 101, "name", "Dr. Smith", "department", "Cardiology"));
        doctors.add(Map.of("id", 102, "name", "Dr. Jones", "department", "General Medicine"));
        doctors.add(Map.of("id", 103, "name", "Dr. Patel", "department", "General Medicine"));
        return doctors;
    }

    @PostMapping("/book")
    public Map<String, Object> bookAppointment(@RequestBody Map<String, Object> request) {
        Appointment appt = new Appointment();

        // since we don't have actual doctor or patient relations here, we fake them
        appt.setAppointmentTime(LocalDateTime.parse((String) request.get("time")));
        appt.setStatus("CONFIRMED");

        appointmentRepository.save(appt);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Appointment booked successfully");
        return response;
    }

    @Data
    public static class SymptomRequest {
        private String symptoms;

        public String getSymptoms() {
            return symptoms;
        }

        public void setSymptoms(String symptoms) {
            this.symptoms = symptoms;
        }
    }
}
