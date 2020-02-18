package com.github.matjanko.teksystem.employee.model.employee;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * @author matjanko
 *
 */

@Entity
@Table(name = "employees")
@Getter @RequiredArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString
public class Employee {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EMPLOYER_SEQUENCE")
    @Column(name = "employee_id")
    private Long id;

    @NotBlank @NonNull
    @Column(name = "employee_name", nullable = false, length = 50)
    private String firstName;

    @NotBlank @NonNull
    @Column(name = "employee_surname", nullable = false, length = 50)
    private String lastName;

    @NotBlank @NonNull
    @Column(name = "employee_login", nullable = false, unique = true, length = 50)
    private String username;

    @Column(name = "employee_email")
    @Email
    private String email;

    @Column(name = "is_hired", nullable = false)
    private Boolean isHired = true;

    protected Employee() {}

}
