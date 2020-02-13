package pl.tekprojekt.teksystem.reports.domain.customer;

import lombok.Getter;

import javax.persistence.*;

/**
 * @author matjanko
 *
 */

@Getter
@Entity
@Table(name = "customers")
public class Customer {

    @Id @Column(name = "customer_id")
    private Long id;

    @Column(name = "customer_name")
    private String name;

}
