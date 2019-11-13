package pl.tekprojekt.teksystem.reports.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author matjanko
 *
 */

@Getter
@Setter
public class ProjectEffortDto {

    private String projectIndex;
    private String customerName;
    private String projectName;
    private String hours;
    private boolean hasProgress;
}
