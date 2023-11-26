package com.devinhouse.timekeepingsystem.model.transport;

import com.devinhouse.timekeepingsystem.model.Employee;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateEmployeeDTO (@NotBlank String name, @NotBlank String occupation, @NotNull Float wage) {
}
