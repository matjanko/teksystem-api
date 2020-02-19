package com.github.matjanko.teksystem.employee.services;

import com.github.matjanko.teksystem.employee.services.impl.PolishEmployeeRoleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

}
