package com.github.matjanko.teksystem.employee.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author matjanko
 *
 */

@Getter @Setter
public class NewEmployeeDto {

    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    private String username;
    @NotNull
    private RoleDto role;
    @Email
    private String email;

}
