package sample.data.jpa.service;

import org.springframework.data.jpa.repository.JpaRepository;
import sample.data.jpa.domain.Teacher;

public interface TeacherDAO extends JpaRepository<Teacher, Long> {}
