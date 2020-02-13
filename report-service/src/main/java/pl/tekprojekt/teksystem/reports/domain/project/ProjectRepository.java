package pl.tekprojekt.teksystem.reports.domain.project;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.tekprojekt.teksystem.reports.domain.project.projection.ProjectNameView;

import java.util.List;

/**
 * @author matjanko
 *
 */

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

    @EntityGraph(type = EntityGraph.EntityGraphType.LOAD,
            attributePaths = {
                    "customer"
            }
    )
    List<ProjectNameView> findAllProjectNamesByOrderByIndexNumberDesc();
}
