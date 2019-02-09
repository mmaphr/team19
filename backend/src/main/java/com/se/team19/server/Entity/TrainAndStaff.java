package com.se.team19.server.Entity;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Getter @Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "trainAndStaff", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"Staff_ID", "TrainStaff_ID"})
})
public class TrainAndStaff {
    @Id
    @SequenceGenerator(name="trainandstaff_seq",sequenceName="trainandstaff_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="trainandstaff_seq")
    @Column(name ="TrainAndStaff_ID",unique = true, nullable = false)
    private @NonNull Long id;

    @ManyToOne
    @JoinColumn(name = "Staff_ID", insertable = true)
    private Staff trainAndStaffStaff;


    @ManyToOne
    @JoinColumn(name = "TrainStaff_ID", insertable = true)
    private TrainStaff trainAndStaffTrainStaff;
}
