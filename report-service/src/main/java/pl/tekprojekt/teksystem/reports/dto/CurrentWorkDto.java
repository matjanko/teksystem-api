package pl.tekprojekt.teksystem.reports.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author matjanko
 *
 */

@Getter
@Setter
public class CurrentWorkDto {

    private Long id;
    private TimeRecordDto timeRecord;
}
