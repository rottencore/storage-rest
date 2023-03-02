package ru.vosmfc.mfcstorage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vosmfc.mfcstorage.domain.Recipient;

@Repository
public interface RecipientRepository extends JpaRepository<Recipient, Long> {
}
