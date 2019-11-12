package pl.tekprojekt.teksystem.reports.domain.timerecord;

import lombok.Getter;
import pl.tekprojekt.teksystem.reports.domain.employee.Employee;
import pl.tekprojekt.teksystem.reports.domain.project.Project;
import pl.tekprojekt.teksystem.reports.domain.projectstage.ProjectStage;
import pl.tekprojekt.teksystem.reports.domain.workset.Workset;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author matjanko
 *
 */

@Getter
@Entity
@Table(name = "time_records")
public class TimeRecord {

    @Id @Column(name = "record_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @ManyToOne
    @JoinColumn(name = "project_stage_id")
    private ProjectStage projectStage;

    @ManyToOne
    @JoinColumn(name = "workset_id")
    private Workset workset;

    @Column(name = "additional_cost")
    private Boolean isAddCost;

    @Column(name = "mistake")
    private Boolean isMistake;

    @Column(name = "start_time")
    private LocalDateTime startTime;

    @Column(name = "end_time")
    private LocalDateTime endTime;

}
