package pl.tekprojekt.teksystem.reports.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author matjanko
 *
 */

@Getter
@Setter
public class TimeRecordDto {

    private String employeeName;
    private String projectName;
    private String projectStageName;
    private String worksetName;
    private boolean isAddCost;
    private boolean isMistake;
    private String startTime;
    private String endTime;
}
