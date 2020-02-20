package com.github.matjanko.teksystem.employee.services.impl;

import com.github.matjanko.teksystem.employee.domain.employee.EmployeeRole;
import com.github.matjanko.teksystem.employee.exceptions.IllegalRoleException;
import com.github.matjanko.teksystem.employee.exceptions.IllegalRoleNameException;
import com.github.matjanko.teksystem.employee.services.EmployeeRoleService;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author matjanko
 *
 */
@Service
public class PolishEmployeeRoleService implements EmployeeRoleService {

    public static Map<EmployeeRole, String> roleNames = new HashMap<>();

    static {
        roleNames.put(EmployeeRole.BOSS, "zarząd");
        roleNames.put(EmployeeRole.MANAGER, "kierownik");
        roleNames.put(EmployeeRole.ASSISTANT, "asystent");
        roleNames.put(EmployeeRole.SECRETARY, "sekretariat");
    }

    @Override
    public List<String> getAllRoleNames() {
        return roleNames.values().stream()
                .sorted()
                .collect(Collectors.toList());
    }

    @Override
    public String getRoleName(EmployeeRole role) throws IllegalRoleException {
        return roleNames.entrySet().stream()
                .filter(r -> r.getKey() == role)
                .findFirst()
                .map(Map.Entry::getValue)
                .orElseThrow(() -> new IllegalRoleException(
                        "Chosen employee role doesn't have polish name."));
    }

    @Override
    public EmployeeRole getRole(@NotNull String roleName) {
        return roleNames.entrySet().stream()
                .filter(r -> r.getValue().equals(roleName))
                .findFirst()
                .map(Map.Entry::getKey)
                .orElseThrow(() -> new IllegalRoleNameException(
                        "Cannot find employee role for " + roleName));
    }
}
