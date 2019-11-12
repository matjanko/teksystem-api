package pl.tekprojekt.teksystem.reports.domain.projectstage;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author matjanko
 *
 */

@Getter
@Entity
@Table(name = "project_stages")
public class ProjectStage {

    @Id @Column(name = "project_stage_id")
    private Long id;

    @Column(name = "project_stage_name")
    private String name;
}
