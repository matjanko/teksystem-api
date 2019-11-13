package pl.tekprojekt.teksystem.reports.service;

import org.springframework.stereotype.Service;
import pl.tekprojekt.teksystem.reports.domain.timerecord.TimeRecordRepository;
import pl.tekprojekt.teksystem.reports.dto.EmployeeCurrentWorkDto;
import pl.tekprojekt.teksystem.reports.dto.TimeRecordDto;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author matjanko
 *
 */

@Service
public class TimeRecordService {

    private TimeRecordRepository timeRecordRepository;

    public TimeRecordService(TimeRecordRepository timeRecordRepository) {
        this.timeRecordRepository = timeRecordRepository;
    }

    public List<EmployeeCurrentWorkDto> findEmployeesCurrentWork() {

        return null;
    }

    public List<TimeRecordDto> findAllTimeRecordsByEmployeeId(Long employeeId) {
        return timeRecordRepository.findAllTimeRecordsByEmployeeIdOrderByStartTimeDesc(employeeId).stream().map(tr -> {
            TimeRecordDto timeRecordDto = new TimeRecordDto();
            timeRecordDto.setEmployeeName(tr.getEmployee().toString());
            timeRecordDto.setProjectName(tr.getProject().toString());

            if (tr.getProjectStage() != null) {
                timeRecordDto.setProjectStageName(tr.getProjectStage().getName());
            }

            if (tr.getWorkset() != null) {
                timeRecordDto.setWorksetName(tr.getWorkset().toString());
            }

            timeRecordDto.setAddCost(tr.getIsAddCost());
            timeRecordDto.setMistake(tr.getIsMistake());
            timeRecordDto.setStartTime(tr.getStartTime().toString());
            timeRecordDto.setEndTime(tr.getEndTime().toString());
            return timeRecordDto;
        }).collect(Collectors.toList());
    }
}
