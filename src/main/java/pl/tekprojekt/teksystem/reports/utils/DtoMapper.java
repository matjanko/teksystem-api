package pl.tekprojekt.teksystem.reports.utils;

import org.springframework.stereotype.Component;
import pl.tekprojekt.teksystem.reports.domain.model.ProjectStage;
import pl.tekprojekt.teksystem.reports.dto.ProjectStageDto;

/**
 * @author matjanko
 *
 */

@Component
public class DtoMapper {

    public ProjectStageDto map(ProjectStage projectStage) {
        return new ProjectStageDto(projectStage.getId(), projectStage.getName());
    }
}
