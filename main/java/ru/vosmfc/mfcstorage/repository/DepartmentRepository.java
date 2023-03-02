package ru.vosmfc.mfcstorage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vosmfc.mfcstorage.domain.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
