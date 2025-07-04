package com.prajwalmh.Triagepro.repositories;

import com.prajwalmh.Triagepro.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}