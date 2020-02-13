package pl.tekprojekt.teksystem.reports.domain.project.projection;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author matjanko
 *
 */


public interface ProjectNameView {

    Long getId();

    @Value("#{target.index.toString()} - #{target.customer?.name ?: ''} - #{target.name}")
    String getFullName();
}
