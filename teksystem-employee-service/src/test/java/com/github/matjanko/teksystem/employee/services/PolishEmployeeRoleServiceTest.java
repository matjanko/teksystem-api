package com.github.matjanko.teksystem.employee.services;

import com.github.matjanko.teksystem.employee.domain.employee.EmployeeRole;
import com.github.matjanko.teksystem.employee.exceptions.IllegalRoleNameException;
import com.github.matjanko.teksystem.employee.services.impl.PolishEmployeeRoleService;
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
public class PolishEmployeeRoleServiceTest {

    private EmployeeRoleService employeeRoleService;

    @BeforeEach
    public void initPolishEmployeeRoleService() {
        employeeRoleService = new PolishEmployeeRoleService();
    }

    @Test
    public void getAllRoleNamesTest() {
        // given
        List<String> expectedRoleNames = Arrays.asList(
                "asystent", "kierownik", "sekretariat", "zarząd");
        // when
        List<String> actualRoleNames = employeeRoleService.getAllRoleNames();
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
        String actualName = employeeRoleService.getRoleName(employeeRole);
        // then
        assertEquals(expectedName, actualName);
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
        EmployeeRole actualRole = employeeRoleService.getRole(roleName);
        // then
        assertEquals(expectedRole, actualRole);
    }

    @Test
    public void shouldThrowIllegalRoleNameExceptionWhenGetRoleTest() {
        // then
        assertThrows(IllegalRoleNameException.class,
                () -> employeeRoleService.getRole("wrongName"));
    }

}
