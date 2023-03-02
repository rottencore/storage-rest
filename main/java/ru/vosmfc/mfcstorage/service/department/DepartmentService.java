package ru.vosmfc.mfcstorage.service.department;

import ru.vosmfc.mfcstorage.dto.DepartmentDto;
import ru.vosmfc.mfcstorage.exception.ObjectAlreadyExistException;

import java.util.List;

public interface DepartmentService {

    void saveDepartment(DepartmentDto departmentDto) throws ObjectAlreadyExistException;

    List<DepartmentDto> findAllDepartments();

}
