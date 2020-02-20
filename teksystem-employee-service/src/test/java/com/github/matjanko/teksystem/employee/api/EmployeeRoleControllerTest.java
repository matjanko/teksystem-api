package com.github.matjanko.teksystem.employee.api;

import com.github.matjanko.teksystem.employee.services.EmployeeRoleService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.when;

/**
 * @author matjanko
 *
 */
@ExtendWith(MockitoExtension.class)
public class EmployeeRoleControllerTest {

    @InjectMocks
    EmployeeRoleController employeeRoleController;

    @Mock
    EmployeeRoleService roleService;

    @Test
    public void getAllEmployeeRoleNamesTest() {
        // given
        List<String> expectedRoleNames = Collections.singletonList(
                "asystent, kierownik, sekretariat, zarząd");

        when(roleService.getAllRoleNames()).thenReturn(expectedRoleNames);

        // when
        ResponseEntity<List<String>> actualRoleNames =
                employeeRoleController.getAllEmployeeRoleNames();

        // then
        assertThat(actualRoleNames.getStatusCodeValue()).isEqualTo(200);
        assertThat(actualRoleNames.getBody()).isEqualTo(expectedRoleNames);
    }
}
