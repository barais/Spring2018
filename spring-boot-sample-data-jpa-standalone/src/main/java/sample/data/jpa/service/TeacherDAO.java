package sample.data.jpa.service;

import org.springframework.data.jpa.repository.JpaRepository;
import sample.data.jpa.domain.Teacher;

import java.util.Optional;

public interface TeacherDAO extends JpaRepository<Teacher, Long> {
    Optional<Teacher> findTeacherByFirstNameAndLastName(String firstName, String lastName);
}
