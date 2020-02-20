package com.github.matjanko.teksystem.employee.services;

import com.github.matjanko.teksystem.employee.domain.employee.EmployeeRole;
import com.github.matjanko.teksystem.employee.exceptions.IllegalRoleNameException;
import com.github.matjanko.teksystem.employee.services.impl.PolishEmployeeRoleService;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author matjanko
 *
 */

@RunWith(JUnitParamsRunner.class)
public class PolishEmployeeRoleServiceTest {

    private EmployeeRoleService employeeRoleService;

    @Before
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

    @Test
    @Parameters({
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

    @Test
    @Parameters({
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

    @Test(expected = IllegalRoleNameException.class)
    public void shouldThrowIllegalRoleNameExceptionWhenGetRoleTest() {
        // when
        employeeRoleService.getRole("wrongName");
        // then
        // throw exception
    }

}
