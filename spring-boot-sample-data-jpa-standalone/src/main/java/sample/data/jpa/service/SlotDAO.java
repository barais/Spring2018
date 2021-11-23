package sample.data.jpa.service;

import org.springframework.data.jpa.repository.JpaRepository;
import sample.data.jpa.domain.Slot;

public interface SlotDAO extends JpaRepository<Slot, Long> {}
