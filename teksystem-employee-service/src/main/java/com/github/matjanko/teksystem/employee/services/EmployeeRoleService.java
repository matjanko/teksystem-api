package com.github.matjanko.teksystem.employee.services;

import com.github.matjanko.teksystem.employee.domain.employee.EmployeeRole;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author matjanko
 *
 */

@Service
public interface EmployeeRoleService {

    List<String> getAllRoleNames();

    String getRoleName(EmployeeRole role);

    EmployeeRole getRole(@NotNull String roleName);

}
