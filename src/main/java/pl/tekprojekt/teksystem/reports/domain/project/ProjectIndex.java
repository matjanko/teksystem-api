package pl.tekprojekt.teksystem.reports.domain.project;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author matjanko
 *
 */

@Getter
@Embeddable
public class ProjectIndex {

    @Column(name = "project_symbol")
    private Character symbol;

    @Column(name = "project_number")
    private Long number;

    @Override
    public String toString() {
        return String.format("%s%04d", symbol.toString(), number);
    }
}
