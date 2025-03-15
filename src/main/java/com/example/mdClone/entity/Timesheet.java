package com.example.mdClone.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Timesheet {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @CreatedDate
    private LocalDate date;

    @NotEmpty(message = "start date can NOT be null or empty")
    private Date startDate;

    @NotEmpty(message = "end date can NOT be null or empty")
    private Date endDate;

    @ManyToOne(cascade= {CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "employee_id")
    @JsonBackReference
    @NotEmpty(message = "employee can NOT be null or empty")
    private Employee employee;

}
