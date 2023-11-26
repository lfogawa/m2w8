package com.devinhouse.timekeepingsystem.model.transport;

import com.devinhouse.timekeepingsystem.model.Registers;
import com.devinhouse.timekeepingsystem.model.enums.RegisterType;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record RegistersDTO (Long id, @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss") LocalDateTime  registeredAt, RegisterType type){
    public RegistersDTO(Registers registers){
        this(registers.getId(), registers.getRegisterAt(), registers.getType());
    }
}
