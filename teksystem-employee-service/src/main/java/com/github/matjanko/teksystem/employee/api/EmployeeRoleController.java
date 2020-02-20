package com.github.matjanko.teksystem.employee.api;

import com.github.matjanko.teksystem.employee.services.EmployeeRoleService;
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
public class EmployeeRoleController {

    private final EmployeeRoleService roleService;

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<String>> getAllEmployeeRoleNames() {
        List<String> roleNames = roleService.getAllRoleNames();
        return new ResponseEntity<>(roleNames, HttpStatus.OK);
    }

}
