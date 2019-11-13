package pl.tekprojekt.teksystem.reports.domain.projecteffort;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author matjanko
 *
 */

@Repository
public interface ProjectEffortRepository extends JpaRepository<ProjectEffort, Long> {

    @EntityGraph(type = EntityGraph.EntityGraphType.LOAD,
            attributePaths = {
                    "project",
                    "project.customer",
            }
    )
    List<ProjectEffort> findAllProjectEffortsByOrderByHoursDesc();
}
