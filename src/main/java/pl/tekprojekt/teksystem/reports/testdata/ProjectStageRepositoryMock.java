package pl.tekprojekt.teksystem.reports.testdata;

import pl.tekprojekt.teksystem.reports.domain.model.ProjectStage;

import java.util.Arrays;
import java.util.List;

/**
 * @author matjanko
 *
 */
public class ProjectStageRepositoryMock {

    public List<ProjectStage> findAll() {
        return Arrays.asList(
                new ProjectStage(1L, "projekt wykonawczy"),
                new ProjectStage(2L, "projekt budowlany"),
                new ProjectStage(3L, "ekspertyza, opinia")
        );
    }

}
