package sample.data.jpa.service;

import org.springframework.data.jpa.repository.JpaRepository;
import sample.data.jpa.domain.Slot;

import java.util.List;

public interface SlotDAO extends JpaRepository<Slot, Long> {
    List<Slot> findAllByTeacherId(Long teacher_id);
}
