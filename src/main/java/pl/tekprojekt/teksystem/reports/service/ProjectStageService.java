package pl.tekprojekt.teksystem.reports.service;

import org.springframework.stereotype.Service;
import pl.tekprojekt.teksystem.reports.dto.ProjectStageDto;

import java.util.List;

/**
 * @author matjanko
 *
 */

@Service
public interface ProjectStageService {

    List<ProjectStageDto> getAll();

}
