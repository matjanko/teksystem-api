package pl.tekprojekt.teksystem.reports.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.tekprojekt.teksystem.reports.dto.CurrentWorkDto;
import pl.tekprojekt.teksystem.reports.dto.TimeRecordDto;
import pl.tekprojekt.teksystem.reports.service.CurrentWorkService;
import pl.tekprojekt.teksystem.reports.service.TimeRecordService;

import java.util.List;

/**
 * @author matjanko
 *
 */

@RestController
@CrossOrigin
@RequestMapping(path = "/time-records")
public class TimeRecordController {

    private TimeRecordService timeRecordService;
    private CurrentWorkService currentWorkService;

    public TimeRecordController(TimeRecordService timeRecordService,
                                CurrentWorkService currentWorkService) {
        this.timeRecordService = timeRecordService;
        this.currentWorkService = currentWorkService;
    }

    @GetMapping("employees/{id}")
    public ResponseEntity<List<TimeRecordDto>> getEmployeeTimeRecords(@PathVariable(name = "id") Long employeeId) {
        List<TimeRecordDto> records = timeRecordService.findAllTimeRecordsByEmployeeId(employeeId);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(records);
    }

    @GetMapping("/current")
    public ResponseEntity<List<CurrentWorkDto>> getCurrentTimeRecords() {
        List<CurrentWorkDto> records = currentWorkService.findCurrentWork();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(records);
    }
}
