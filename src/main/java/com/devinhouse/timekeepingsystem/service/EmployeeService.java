package com.devinhouse.timekeepingsystem.service;

import com.devinhouse.timekeepingsystem.model.Employee;
import com.devinhouse.timekeepingsystem.model.Registers;
import com.devinhouse.timekeepingsystem.model.transport.*;
import com.devinhouse.timekeepingsystem.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @Transactional
    public GeneralEmployeeDTO create(CreateEmployeeDTO body){
        Employee newEmployee = this.employeeRepository.save(new Employee(body));
        return new GeneralEmployeeDTO(newEmployee);
    }

    @Transactional
    public RegistersDTO createRegisters(Long id, CreateRegistersDTO body) {
        Employee employee = this.employeeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Employee with id not found: " + id));
        Registers registers = new Registers(body.type(), employee);
        employee.getRegisters().add(registers);
        return new RegistersDTO(registers);
    }

    public Page<GeneralEmployeeDTO> listAll(Pageable pageable) {
        return this.employeeRepository.findAll(pageable).map(GeneralEmployeeDTO::new);
    }

    public DetailedEmployeeDTO getEmployee(Long id) {
        return this.employeeRepository.findById(id).map(DetailedEmployeeDTO::new).orElseThrow(() -> new IllegalArgumentException("Employee with id not found: " + id));
    }

}
