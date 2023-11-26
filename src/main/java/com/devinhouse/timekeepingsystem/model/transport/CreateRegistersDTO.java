package com.devinhouse.timekeepingsystem.model.transport;

import com.devinhouse.timekeepingsystem.model.enums.RegisterType;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record CreateRegistersDTO (@NotNull RegisterType type){
}