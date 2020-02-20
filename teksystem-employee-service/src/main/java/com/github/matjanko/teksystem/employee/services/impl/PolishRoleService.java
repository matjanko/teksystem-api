package com.github.matjanko.teksystem.employee.services.impl;

import com.github.matjanko.teksystem.employee.domain.employee.EmployeeRole;
import com.github.matjanko.teksystem.employee.dto.RoleDto;
import com.github.matjanko.teksystem.employee.exceptions.IllegalRoleException;
import com.github.matjanko.teksystem.employee.services.RoleService;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author matjanko
 *
 */
@Service
public class PolishRoleService implements RoleService {

    public static Map<EmployeeRole, String> roleNames = new HashMap<>();

    static {
        roleNames.put(EmployeeRole.BOSS, "zarząd");
        roleNames.put(EmployeeRole.MANAGER, "kierownik");
        roleNames.put(EmployeeRole.ASSISTANT, "asystent");
        roleNames.put(EmployeeRole.SECRETARY, "sekretariat");
    }

    @Override
    public List<RoleDto> getAllRoles() {
        return roleNames.values().stream()
                .sorted()
                .map(RoleDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public RoleDto getRole(EmployeeRole role) throws IllegalRoleException {
        return roleNames.entrySet().stream()
                .filter(r -> r.getKey() == role)
                .findFirst()
                .map(rs -> new RoleDto(rs.getValue()))
                .orElseThrow(() -> new IllegalRoleException(
                        "Chosen role doesn't have polish name."));
    }

    @Override
    public EmployeeRole getRole(@NotNull RoleDto role) {
        return roleNames.entrySet().stream()
                .filter(r -> r.getValue().equals(role.getName()))
                .findFirst()
                .map(Map.Entry::getKey)
                .orElseThrow(() -> new IllegalRoleException(
                        "Cannot find employee role for " + role));
    }
}
