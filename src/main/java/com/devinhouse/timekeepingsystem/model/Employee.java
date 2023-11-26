package com.devinhouse.timekeepingsystem.model;

import com.devinhouse.timekeepingsystem.model.transport.CreateEmployeeDTO;
import com.devinhouse.timekeepingsystem.model.transport.RegistersDTO;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String occupation;

    @Column(nullable = false)
    private Float wage;


    @OneToMany(mappedBy = "employee", orphanRemoval = true, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Registers> registers = new ArrayList<>();


    public Employee() {
    }

    public Employee(CreateEmployeeDTO body) {
        this.name = body.name();
        this.occupation = body.occupation();
        this.wage = body.wage();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public Float getWage() {
        return wage;
    }

    public void setWage(Float wage) {
        this.wage = wage;
    }

    public List<Registers> getRegisters(){
        return registers;
    }

    public List<RegistersDTO> getRegistersAsObject() {
        return this.registers.stream().map(RegistersDTO::new).toList();
    }
}
