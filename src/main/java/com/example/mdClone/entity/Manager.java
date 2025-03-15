package com.example.mdClone.entity;

import com.example.mdClone.utils.Person;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Manager extends Person {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="Id")
    private int id;

    @OneToMany(mappedBy = "manager")
    @JsonManagedReference
    private List<Employee> employeeList;
}
