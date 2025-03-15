package com.example.mdClone.utils;

import jakarta.persistence.MappedSuperclass;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@MappedSuperclass
public abstract class Person {

    private String firstName;
    private String lastName;
}
