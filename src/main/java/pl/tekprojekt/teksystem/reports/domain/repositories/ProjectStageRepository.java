package pl.tekprojekt.teksystem.reports.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.tekprojekt.teksystem.reports.domain.model.ProjectStage;


/**
 * @author matjanko
 *
 */

@Repository
public interface ProjectStageRepository extends JpaRepository<ProjectStage, Long> {

}
