package com.github.matjanko.teksystem.employee.api;

import com.github.matjanko.teksystem.employee.dto.RoleDto;
import com.github.matjanko.teksystem.employee.services.RoleService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.when;

/**
 * @author matjanko
 *
 */
@ExtendWith(MockitoExtension.class)
public class RoleControllerTest {

    @InjectMocks
    RoleController roleController;

    @Mock
    RoleService roleService;

    @Test
    public void getAllEmployeeRoleNamesTest() {
        // given
        List<RoleDto> expectedRoles = Arrays.asList(
                new RoleDto("asystent"),
                new RoleDto("kierownik"),
                new RoleDto("sekretariat"),
                new RoleDto("zarząd"));

        when(roleService.getAllRoles()).thenReturn(expectedRoles);

        // when
        ResponseEntity<List<RoleDto>> actualRoleNames =
                roleController.getAllEmployeeRoleNames();

        // then
        assertThat(actualRoleNames.getStatusCodeValue()).isEqualTo(200);
        assertThat(actualRoleNames.getBody()).isEqualTo(expectedRoles);
    }
}
