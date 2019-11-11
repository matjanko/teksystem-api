package pl.tekprojekt.teksystem.reports.service;

import org.springframework.stereotype.Service;
import pl.tekprojekt.teksystem.reports.dto.ProjectNameDto;
import pl.tekprojekt.teksystem.reports.domain.project.ProjectRepository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author matjanko
 *
 */

@Service
public class ProjectService {

    private ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<ProjectNameDto> findAllProjectNames() {
        return projectRepository.findAllProjectNamesByOrderByIndexNumberDesc().stream()
                .map(projectNameView -> new ProjectNameDto(
                        projectNameView.getId(),
                        projectNameView.getFullName()))
                .collect(Collectors.toList());
    }
}
