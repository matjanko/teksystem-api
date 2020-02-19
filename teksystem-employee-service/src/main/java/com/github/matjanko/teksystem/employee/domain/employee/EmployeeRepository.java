package com.github.matjanko.teksystem.employee.domain.employee;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.validation.constraints.NotBlank;

/**
 * @author matjanko
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Employee findByUsername(@NotBlank String username);

    boolean existsEmployeeByUsername(@NotBlank String username);

}