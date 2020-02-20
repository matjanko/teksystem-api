package com.github.matjanko.teksystem.employee.services;

import com.github.matjanko.teksystem.employee.domain.employee.EmployeeRole;
import com.github.matjanko.teksystem.employee.dto.RoleDto;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author matjanko
 *
 */

@Service
public interface RoleService {

    List<RoleDto> getAllRoles();

    RoleDto getRole(EmployeeRole role);

    EmployeeRole getRole(@NotNull RoleDto role);

}
