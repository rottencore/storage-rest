package ru.vosmfc.mfcstorage.converter;

import org.springframework.stereotype.Component;
import ru.vosmfc.mfcstorage.domain.Department;
import ru.vosmfc.mfcstorage.dto.DepartmentDto;

@Component
public class DepartmentConverter {

    public Department fromDepartmentDtoToDepartment(DepartmentDto departmentDto) {
        return new Department(departmentDto.getDepartmentName());
    }

    public DepartmentDto fromDepartmentToDepartmentDto(Department department) {
        return new DepartmentDto(department.getId(), department.getDepartmentName());
    }

}
