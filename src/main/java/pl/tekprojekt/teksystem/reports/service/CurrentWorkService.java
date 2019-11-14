package pl.tekprojekt.teksystem.reports.service;

import org.springframework.stereotype.Service;
import pl.tekprojekt.teksystem.reports.domain.currentwork.CurrentWorkRepository;
import pl.tekprojekt.teksystem.reports.domain.timerecord.TimeRecord;
import pl.tekprojekt.teksystem.reports.dto.CurrentWorkDto;
import pl.tekprojekt.teksystem.reports.utils.MappingUtils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author
 *
 */

@Service
public class CurrentWorkService {

    private CurrentWorkRepository currentWorkRepository;

    public CurrentWorkService(CurrentWorkRepository currentWorkRepository) {
        this.currentWorkRepository = currentWorkRepository;
    }

    public List<CurrentWorkDto> findCurrentWork() {
        return currentWorkRepository.findAllByOrderByTimeRecordEmployeeFirstName().stream()
                .filter(cw -> cw.getTimeRecord().getStartTime().isAfter(LocalDateTime.now().minusSeconds(70)))
                .map(cw -> {
                    CurrentWorkDto currentWorkDto = new CurrentWorkDto();
                    currentWorkDto.setId(cw.getId());
                    currentWorkDto.setTimeRecord(MappingUtils.convertFromEntity(cw.getTimeRecord()));
                    return currentWorkDto;
        }).collect(Collectors.toList());
    }
}
