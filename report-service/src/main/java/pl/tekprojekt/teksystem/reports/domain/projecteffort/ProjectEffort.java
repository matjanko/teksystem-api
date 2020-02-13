package pl.tekprojekt.teksystem.reports.domain.projecteffort;

import lombok.Getter;
import pl.tekprojekt.teksystem.reports.domain.project.Project;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author matjanko
 *
 */

@Getter
@Entity
@Table(name = "project_efforts")
public class ProjectEffort implements Serializable {

    @Id
    @Column(name = "record_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @Column(name = "hours")
    private Integer hours;

    @Column(name = "has_progress")
    private Boolean hasProgress;
}
