package pl.tekprojekt.teksystem.reports.domain.workset;

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
@Table(name = "activities")
public class Activity {

    @Id @Column(name = "activity_id")
    private Long id;

    @Column(name = "activity_name")
    private String name;
}
