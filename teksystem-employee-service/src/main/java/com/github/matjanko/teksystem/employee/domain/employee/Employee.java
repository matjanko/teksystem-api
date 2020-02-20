package com.github.matjanko.teksystem.employee.domain.employee;

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
@Getter @Setter
@EqualsAndHashCode(of = "id")
@ToString
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EMPLOYEE_SEQ")
    @Column(name = "employee_id")
    private Long id;

    @NotBlank
    @Column(name = "employee_name", nullable = false, length = 50)
    private String firstName;

    @NotBlank
    @Column(name = "employee_surname", nullable = false, length = 50)
    private String lastName;

    @NotBlank
    @Column(name = "employee_login", nullable = false, unique = true, length = 50)
    private String username;

    @Enumerated(EnumType.STRING)
    @Column(name = "employee_role", nullable = false)
    private EmployeeRole role;

    @Column(name = "employee_email")
    @Email
    private String email;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;

    protected Employee() {}

}
