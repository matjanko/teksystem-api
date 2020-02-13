package pl.tekprojekt.teksystem.reports.domain.timerecord;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author matjanko
 *
 */

@Repository
public interface TimeRecordRepository extends JpaRepository<TimeRecord, Long> {

    @EntityGraph(type = EntityGraph.EntityGraphType.LOAD,
            attributePaths = {
                    "employee",
                    "project",
                    "project.customer",
                    "projectStage",
                    "workset",
                    "workset.firstLevelActivity",
                    "workset.secondLevelActivity",
                    "workset.thirdLevelActivity",
                    "workset.fourthLevelActivity",
            }
    )
    List<TimeRecord> findAllTimeRecordsByEmployeeIdOrderByStartTimeDesc(Long employeeID);
}
