package com.devinhouse.timekeepingsystem.model.transport;

import com.devinhouse.timekeepingsystem.model.Employee;

public record GeneralEmployeeDTO (Long id, String name, String occupation, Float wage) {
    public GeneralEmployeeDTO(Employee employee) {
        this(employee.getId(), employee.getName(), employee.getOccupation(), employee.getWage());
    }
}
