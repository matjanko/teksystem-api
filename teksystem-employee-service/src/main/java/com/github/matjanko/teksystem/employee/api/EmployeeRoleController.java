package com.github.matjanko.teksystem.employee.api;

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
public class EmployeeRoleController {

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<String>> getAllEmployeeRoleNames() {
        return null;
    }
}
