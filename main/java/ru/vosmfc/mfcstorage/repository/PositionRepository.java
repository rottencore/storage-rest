package ru.vosmfc.mfcstorage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vosmfc.mfcstorage.domain.Position;

public interface PositionRepository extends JpaRepository<Position, Long> {
}
