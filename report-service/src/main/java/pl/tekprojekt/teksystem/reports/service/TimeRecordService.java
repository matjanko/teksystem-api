package pl.tekprojekt.teksystem.reports.service;

import org.springframework.stereotype.Service;
import pl.tekprojekt.teksystem.reports.domain.timerecord.TimeRecordRepository;
import pl.tekprojekt.teksystem.reports.dto.TimeRecordDto;
import pl.tekprojekt.teksystem.reports.utils.MappingUtils;

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

    public List<TimeRecordDto> findAllTimeRecordsByEmployeeId(Long employeeId) {
        return timeRecordRepository.findAllTimeRecordsByEmployeeIdOrderByStartTimeDesc(employeeId).stream()
                .map(MappingUtils::convertFromEntity).collect(Collectors.toList());
    }
}
