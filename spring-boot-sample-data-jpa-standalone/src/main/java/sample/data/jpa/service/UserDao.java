package sample.data.jpa.service;

import org.springframework.data.jpa.repository.JpaRepository;

import sample.data.jpa.domain.User;

import java.util.Optional;

public interface UserDao extends JpaRepository<User, Long> {
    Optional<User> findUserByFirstNameAndLastName(String firstName, String lastName);
}