package com.github.matjanko.teksystem.employee.services;

import com.github.matjanko.teksystem.employee.domain.employee.EmployeeRole;
import com.github.matjanko.teksystem.employee.dto.RoleDto;
import com.github.matjanko.teksystem.employee.exceptions.IllegalRoleException;
import com.github.matjanko.teksystem.employee.services.impl.PolishRoleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author matjanko
 *
 */
public class PolishRoleServiceTest {

    private RoleService roleService;

    @BeforeEach
    public void initPolishEmployeeRoleService() {
        roleService = new PolishRoleService();
    }

    @Test
    public void getAllRoleNamesTest() {
        // given
        List<RoleDto> expectedRoleNames = Arrays.asList(
                new RoleDto("asystent"),
                new RoleDto("kierownik"),
                new RoleDto("sekretariat"),
                new RoleDto("zarząd"));
        // when
        List<RoleDto> actualRoleNames = roleService.getAllRoles();
        // then
        assertEquals(expectedRoleNames, actualRoleNames);
    }

    @ParameterizedTest
    @CsvSource({
            "BOSS, zarząd",
            "MANAGER, kierownik",
            "ASSISTANT, asystent",
            "SECRETARY, sekretariat"
    })
    public void getRoleNameTest(EmployeeRole employeeRole, String expectedName) {
        // when
        RoleDto actualRole = roleService.getRole(employeeRole);
        // then
        assertEquals(new RoleDto(expectedName), actualRole);
    }

    @ParameterizedTest
    @CsvSource({
            "zarząd, BOSS",
            "kierownik, MANAGER",
            "asystent, ASSISTANT",
            "sekretariat, SECRETARY"
    })
    public void getRoleTest(String roleName, EmployeeRole expectedRole) {
        // when
        EmployeeRole actualRole = roleService.getRole(new RoleDto(roleName));
        // then
        assertEquals(expectedRole, actualRole);
    }

    @Test
    public void shouldThrowIllegalRoleExceptionWhenGetRoleTest() {
        // then
        assertThrows(IllegalRoleException.class,
                () -> roleService.getRole(new RoleDto("wrongName")));
    }
}
