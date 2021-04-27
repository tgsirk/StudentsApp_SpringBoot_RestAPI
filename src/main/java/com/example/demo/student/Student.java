package com.example.demo.student;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;



@Entity
@Table
/* A lot of lombok features to make code easier to read */
@Getter             //lombok
@Setter             //lombok
@NoArgsConstructor  //lombok
@AllArgsConstructor //lombok
@ToString           //lombok
public class Student {

    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long id;
    private String name;
    private String email;
    @Transient
    private Integer age;
    private LocalDate dob;

    /* Constructor without id, cuz id generates automatically*/
    public Student(String name, String email, LocalDate dob) {
        this.name = name;
        this.email = email;
        this.dob = dob;
    }
    /* lombok generic getter is not enough, cuz age is calculated using date of birth*/
    public Integer getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }

}
