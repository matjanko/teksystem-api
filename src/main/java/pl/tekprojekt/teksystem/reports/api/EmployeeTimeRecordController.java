package pl.tekprojekt.teksystem.reports.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.tekprojekt.teksystem.reports.dto.TimeRecordDto;
import pl.tekprojekt.teksystem.reports.service.TimeRecordService;

import java.util.List;

/**
 * @author matjanko
 *
 */

@RestController
@RequestMapping(path = "/time-records/employees")
public class EmployeeTimeRecordController {

    private TimeRecordService timeRecordService;

    public EmployeeTimeRecordController(TimeRecordService timeRecordService) {
        this.timeRecordService = timeRecordService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<TimeRecordDto>> getEmployeeTimeRecords(@PathVariable(name = "id") Long employeeId) {
        List<TimeRecordDto> records = timeRecordService.findAllTimeRecordsByEmployeeId(employeeId);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(records);
    }
}
