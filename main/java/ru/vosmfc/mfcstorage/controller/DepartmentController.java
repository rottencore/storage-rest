package ru.vosmfc.mfcstorage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vosmfc.mfcstorage.dto.DepartmentDto;
import ru.vosmfc.mfcstorage.exception.ObjectAlreadyExistException;
import ru.vosmfc.mfcstorage.service.department.DepartmentService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/api/departments")
public class DepartmentController {

    @Autowired
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping
    private ResponseEntity<Void> saveDepartment(@Valid @RequestBody DepartmentDto departmentDto) throws ObjectAlreadyExistException {
        departmentService.saveDepartment(departmentDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<DepartmentDto>> findAllDepartments() {
        return new ResponseEntity<>(departmentService.findAllDepartments(), HttpStatus.OK);
    }

}
