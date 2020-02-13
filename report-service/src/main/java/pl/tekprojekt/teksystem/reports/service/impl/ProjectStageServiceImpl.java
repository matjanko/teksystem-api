package pl.tekprojekt.teksystem.reports.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.tekprojekt.teksystem.reports.domain.repositories.ProjectStageRepository;
import pl.tekprojekt.teksystem.reports.dto.ProjectStageDto;
import pl.tekprojekt.teksystem.reports.service.ProjectStageService;
import pl.tekprojekt.teksystem.reports.utils.DtoMapper;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author matjanko
 *
 */

@Service
@RequiredArgsConstructor
public class ProjectStageServiceImpl implements ProjectStageService {

    private final ProjectStageRepository projectStageRepository;
    private final DtoMapper mapper;

    @Override
    public List<ProjectStageDto> getAll() {
        return projectStageRepository.findAll().stream()
                .map(mapper::map)
                .collect(Collectors.toList());
    }
}
