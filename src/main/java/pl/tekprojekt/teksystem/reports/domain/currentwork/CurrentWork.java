package pl.tekprojekt.teksystem.reports.domain.currentwork;

import lombok.Getter;
import pl.tekprojekt.teksystem.reports.domain.timerecord.TimeRecord;

import javax.persistence.*;

/**
 * @author matjanko
 *
 */

@Getter
@Entity
@Table(name = "current_time_records")
public class CurrentWork {

    @Id @Column(name = "row_id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "time_record_id")
    private TimeRecord timeRecord;
}
