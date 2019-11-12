package pl.tekprojekt.teksystem.reports.domain.employee;

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
@Table(name = "employees")
public class Employee {

    @Id @Column(name = "employee_id")
    private Long id;

    @Column(name = "employee_name")
    private String firstName;

    @Column(name = "employee_surname")
    private String lastName;
}
