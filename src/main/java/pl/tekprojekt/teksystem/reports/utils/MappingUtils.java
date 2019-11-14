package pl.tekprojekt.teksystem.reports.utils;

import pl.tekprojekt.teksystem.reports.domain.timerecord.TimeRecord;
import pl.tekprojekt.teksystem.reports.dto.TimeRecordDto;

/**
 * @author matjanko
 *
 */

public class MappingUtils {

    public static TimeRecordDto convertFromEntity(TimeRecord timeRecord) {
        TimeRecordDto timeRecordDto = new TimeRecordDto();
        timeRecordDto.setEmployeeName(timeRecord.getEmployee().toString());
        timeRecordDto.setProjectName(timeRecord.getProject().toString());

        if (timeRecord.getProjectStage() != null) {
            timeRecordDto.setProjectStageName(timeRecord.getProjectStage().getName());
        }

        if (timeRecord.getWorkset() != null) {
            timeRecordDto.setWorksetName(timeRecord.getWorkset().toString());
        }

        timeRecordDto.setAddCost(timeRecord.getIsAddCost());
        timeRecordDto.setMistake(timeRecord.getIsMistake());
        timeRecordDto.setStartTime(timeRecord.getStartTime().toString());
        timeRecordDto.setEndTime(timeRecord.getEndTime().toString());
        return timeRecordDto;
    }
}
