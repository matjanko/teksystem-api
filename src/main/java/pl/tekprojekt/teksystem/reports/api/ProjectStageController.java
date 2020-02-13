package pl.tekprojekt.teksystem.reports.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.tekprojekt.teksystem.reports.dto.ProjectStageDto;
import pl.tekprojekt.teksystem.reports.service.ProjectStageService;

import java.util.List;

/**
 * @author matjanko
 *
 */

@RestController
@RequestMapping("/api/project-stage")
@RequiredArgsConstructor
public class ProjectStageController {

    private final ProjectStageService projectStageService;

    @GetMapping
    public ResponseEntity<List<ProjectStageDto>> getAllProjectStages() {
        return null;
    }
}
