package ru.vosmfc.mfcstorage.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vosmfc.mfcstorage.security.domain.UserRole;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
}
