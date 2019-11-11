package pl.tekprojekt.teksystem.reports.domain.project;

import lombok.Getter;
import pl.tekprojekt.teksystem.reports.domain.customer.Customer;

import javax.persistence.*;

/**
 * @author matjanko
 *
 */

@Getter
@Entity
@Table(name = "projects")
public class Project {

    @Id @Column(name = "project_id")
    private Long id;

    @Embedded
    private ProjectIndex index;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(name = "project_name")
    private String name;

}
