package pl.tekprojekt.teksystem.reports.domain.workset;

import lombok.Getter;

import javax.persistence.*;

/**
 * @author matjanko
 *
 */

@Getter
@Entity
@Table(name = "worksets")
public class Workset {

    @Id @Column(name = "workset_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "first_activity_id")
    private Activity firstLevelActivity;

    @ManyToOne
    @JoinColumn(name = "second_activity_id")
    private Activity secondLevelActivity;

    @ManyToOne
    @JoinColumn(name = "third_activity_id")
    private Activity thirdLevelActivity;

    @ManyToOne
    @JoinColumn(name = "software_id")
    private Activity fourthLevelActivity;

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(firstLevelActivity.getName());
        String space = " - ";

        if (secondLevelActivity != null) {
            builder.append(space).append(secondLevelActivity.getName());
        }

        if (thirdLevelActivity != null) {
            builder.append(space).append(thirdLevelActivity.getName());
        }

        if (fourthLevelActivity != null) {
            builder.append(space).append(fourthLevelActivity.getName());
        }

        return builder.toString();
    }
}
