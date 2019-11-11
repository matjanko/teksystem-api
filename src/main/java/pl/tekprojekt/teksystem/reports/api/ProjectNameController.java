package pl.tekprojekt.teksystem.reports.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.tekprojekt.teksystem.reports.dto.ProjectNameDto;
import pl.tekprojekt.teksystem.reports.service.ProjectService;

import java.util.List;

/**
 * @author matjanko
 *
 */

@RestController
@RequestMapping(path = "/projects/names")
public class ProjectNameController {

    private ProjectService projectService;

    public ProjectNameController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public ResponseEntity<List<ProjectNameDto>> getAllProjectNames() {
        List<ProjectNameDto> projectNames = projectService.findAllProjectNames();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(projectNames);
    }
}
