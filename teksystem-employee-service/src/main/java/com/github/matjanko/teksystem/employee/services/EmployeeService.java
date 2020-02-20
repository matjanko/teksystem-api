package com.github.matjanko.teksystem.employee.services;

import com.github.matjanko.teksystem.employee.domain.employee.EmployeeRole;
import com.github.matjanko.teksystem.employee.dto.EmployeeDto;
import com.github.matjanko.teksystem.employee.dto.NewEmployeeDto;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author matjanko
 *
 */

@Service
public interface EmployeeService {

    List<EmployeeDto> getAllEmployees();

    List<EmployeeDto> getAllEmployeesByRole(EmployeeRole role);

    List<EmployeeDto> getAllActiveEmployees();

    EmployeeDto addNewEmployee(@NotNull NewEmployeeDto employee);

    EmployeeDto editEmployee(@NotNull NewEmployeeDto employee);

    void changeActiveStatus(boolean isActive);
}
