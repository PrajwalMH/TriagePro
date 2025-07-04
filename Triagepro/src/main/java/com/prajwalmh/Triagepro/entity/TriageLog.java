package com.prajwalmh.Triagepro.entity;



import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "triage_logs")
@Data
public class TriageLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(columnDefinition = "TEXT")
    private String symptoms;

    private String predictedDepartment;
    private String triageLevel;
    private LocalDateTime createdAt;


    public TriageLog(Long id, User user, String symptoms, String predictedDepartment, String triageLevel, LocalDateTime createdAt) {
        this.id = id;
        this.user = user;
        this.symptoms = symptoms;
        this.predictedDepartment = predictedDepartment;
        this.triageLevel = triageLevel;
        this.createdAt = createdAt;
    }

    public TriageLog() {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getPredictedDepartment() {
        return predictedDepartment;
    }

    public void setPredictedDepartment(String predictedDepartment) {
        this.predictedDepartment = predictedDepartment;
    }

    public String getTriageLevel() {
        return triageLevel;
    }

    public void setTriageLevel(String triageLevel) {
        this.triageLevel = triageLevel;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
