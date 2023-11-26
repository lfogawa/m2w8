package com.devinhouse.timekeepingsystem.model.transport;

import com.devinhouse.timekeepingsystem.model.Employee;

import java.util.List;

public record DetailedEmployeeDTO(Long id, String name, String occupation, Float wage, List<RegistersDTO> records) {

    public DetailedEmployeeDTO(Employee employee){
        this(employee.getId(), employee.getName(), employee.getOccupation(), employee.getWage(), employee.getRegistersAsObject());
    }
}