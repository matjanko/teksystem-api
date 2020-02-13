package pl.tekprojekt.teksystem.reports.domain.currentwork;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author matjanko
 *
 */

@Repository
public interface CurrentWorkRepository extends JpaRepository<CurrentWork, Long> {

    @EntityGraph(type = EntityGraph.EntityGraphType.LOAD,
            attributePaths = {
                    "timeRecord.employee",
                    "timeRecord.project",
                    "timeRecord.project.customer",
                    "timeRecord.projectStage",
                    "timeRecord.workset",
                    "timeRecord.workset.firstLevelActivity",
                    "timeRecord.workset.secondLevelActivity",
                    "timeRecord.workset.thirdLevelActivity",
                    "timeRecord.workset.fourthLevelActivity",
            }
    )
    List<CurrentWork> findAllByOrderByTimeRecordEmployeeFirstName();
}
