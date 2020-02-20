package com.github.matjanko.teksystem.employee.api;

import com.github.matjanko.teksystem.employee.dto.RoleDto;
import com.github.matjanko.teksystem.employee.services.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author matjanko
 *
 */

@RestController
@RequestMapping("/role")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<RoleDto>> getAllEmployeeRoleNames() {
        List<RoleDto> roles = roleService.getAllRoles();
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }
}
