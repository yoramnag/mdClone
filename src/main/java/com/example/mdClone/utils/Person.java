package com.example.mdClone.utils;

import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@MappedSuperclass
public abstract class Person {

    @NotEmpty(message = "first name can NOT be null or empty")
    private String firstName;
    @NotEmpty(message = "last name can NOT be null or empty")
    private String lastName;
}
