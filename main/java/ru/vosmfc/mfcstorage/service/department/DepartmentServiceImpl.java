package ru.vosmfc.mfcstorage.service.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vosmfc.mfcstorage.converter.DepartmentConverter;
import ru.vosmfc.mfcstorage.domain.Department;
import ru.vosmfc.mfcstorage.dto.DepartmentDto;
import ru.vosmfc.mfcstorage.exception.ObjectAlreadyExistException;
import ru.vosmfc.mfcstorage.repository.DepartmentRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private final DepartmentRepository departmentRepository;

    @Autowired
    private final DepartmentConverter departmentConverter;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository, DepartmentConverter departmentConverter) {
        this.departmentRepository = departmentRepository;
        this.departmentConverter = departmentConverter;
    }

    @Override
    public void saveDepartment(DepartmentDto departmentDto) throws ObjectAlreadyExistException {
        try {
            departmentRepository.save(departmentConverter.fromDepartmentDtoToDepartment(departmentDto));
        } catch (Exception exception) {
            throw new ObjectAlreadyExistException("Department with department name " + departmentDto.getDepartmentName() + " already exist.");
        }
    }

    @Override
    public List<DepartmentDto> findAllDepartments() {
        List<DepartmentDto> departmentDtoList = new ArrayList<>();
        List<Department> departments = departmentRepository.findAll();

        for (Department department : departments) {
            departmentDtoList.add(departmentConverter.fromDepartmentToDepartmentDto(department));
        }

        return departmentDtoList;
    }

}
