package pl.tekprojekt.teksystem.reports.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.tekprojekt.teksystem.reports.dto.ProjectEffortDto;
import pl.tekprojekt.teksystem.reports.service.ProjectEffortService;

import java.util.List;

/**
 * @author matjanko
 *
 */

@RestController
@CrossOrigin
@RequestMapping("/projects/efforts")
public class ProjectEffortController {

    private ProjectEffortService projectEffortService;

    public ProjectEffortController(ProjectEffortService projectEffortService) {
        this.projectEffortService = projectEffortService;
    }

    @GetMapping
    public ResponseEntity<List<ProjectEffortDto>> getAllProjectEfforts() {
        List<ProjectEffortDto> projectEfforts = projectEffortService.findAllProjectEffort();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(projectEfforts);
    }

}
