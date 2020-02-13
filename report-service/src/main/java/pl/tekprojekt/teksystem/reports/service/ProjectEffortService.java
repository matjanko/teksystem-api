package pl.tekprojekt.teksystem.reports.service;

import org.springframework.stereotype.Service;
import pl.tekprojekt.teksystem.reports.domain.projecteffort.ProjectEffortRepository;
import pl.tekprojekt.teksystem.reports.dto.ProjectEffortDto;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author matjanko
 *
 */

@Service
public class ProjectEffortService {

    private ProjectEffortRepository projectEffortRepository;

    public ProjectEffortService(ProjectEffortRepository projectEffortRepository) {
        this.projectEffortRepository = projectEffortRepository;
    }

    public List<ProjectEffortDto> findAllProjectEffort() {
        return projectEffortRepository.findAllProjectEffortsByOrderByHoursDesc().stream().map(pe -> {
            ProjectEffortDto projectEffortDto = new ProjectEffortDto();
            projectEffortDto.setProjectIndex(pe.getProject().getIndex().toString());

            if (pe.getProject().getCustomer() != null) {
                projectEffortDto.setCustomerName(pe.getProject().getCustomer().getName());
            }

            projectEffortDto.setProjectName(pe.getProject().getName());
            projectEffortDto.setHours(pe.getHours().toString());
            projectEffortDto.setHasProgress(pe.getHasProgress());
            return projectEffortDto;
        }).collect(Collectors.toList());
    }
}
