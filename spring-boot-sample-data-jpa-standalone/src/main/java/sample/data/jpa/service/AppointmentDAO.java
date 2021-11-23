package sample.data.jpa.service;

import org.springframework.data.jpa.repository.JpaRepository;
import sample.data.jpa.domain.Appointment;

public interface AppointmentDAO extends JpaRepository<Appointment, Long> {}
