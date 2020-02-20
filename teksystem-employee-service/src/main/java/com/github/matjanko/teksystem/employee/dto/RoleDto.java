package com.github.matjanko.teksystem.employee.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;

/**
 * @author matjanko
 *
 */
@RequiredArgsConstructor
@Getter
@EqualsAndHashCode(of = "name")
public class RoleDto {

    @NotBlank @NonNull
    private String name;
}
