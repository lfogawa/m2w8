package com.devinhouse.timekeepingsystem.model;

import com.devinhouse.timekeepingsystem.model.enums.RegisterType;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
public class Registers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime registerAt;

    @Enumerated(EnumType.STRING)
    private RegisterType type;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false, referencedColumnName = "id")
    private Employee employee;

    public Registers() {
    }

    public Registers(RegisterType type, Employee employee) {
        this.registerAt = LocalDateTime.now();
        this.type = type;
        this.employee = employee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getRegisterAt() {
        return registerAt;
    }

    public void setRegisterAt(LocalDateTime registerAt) {
        this.registerAt = registerAt;
    }

    public RegisterType getType() {
        return type;
    }

    public void setType(RegisterType type) {
        this.type = type;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
