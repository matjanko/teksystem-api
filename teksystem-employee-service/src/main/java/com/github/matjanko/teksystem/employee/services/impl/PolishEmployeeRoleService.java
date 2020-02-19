package com.github.matjanko.teksystem.employee.services.impl;

import com.github.matjanko.teksystem.employee.domain.employee.EmployeeRole;
import com.github.matjanko.teksystem.employee.services.EmployeeRoleService;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.*;

/**
 * @author matjanko
 *
 */
@Service
public class PolishEmployeeRoleService implements EmployeeRoleService {


    @Override
    public List<String> getAllRoleNames() {
        return null;
    }

    @Override
    public String getRoleName(EmployeeRole role) {
        return null;
    }

    @Override
    public EmployeeRole getRole(@NotNull String roleName) {
        return null;
    }
}
