package com.github.matjanko.teksystem.employee.domain.employee;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @author matjanko
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findAllByIsActiveIsTrue();

    Employee findByUsername(@NotBlank String username);

    boolean existsEmployeeByUsername(@NotBlank String username);

}
