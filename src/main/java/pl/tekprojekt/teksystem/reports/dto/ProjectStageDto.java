package pl.tekprojekt.teksystem.reports.dto;

import lombok.*;

import javax.validation.constraints.*;

/**
 * @author matjanko
 *
 */

@AllArgsConstructor
@Getter
@ToString
public class ProjectStageDto {

    private long id;

    @NotBlank
    private String name;
}
