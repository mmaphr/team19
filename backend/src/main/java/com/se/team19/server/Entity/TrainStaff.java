package com.se.team19.server.Entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "TrainStaff")
public class TrainStaff {
    @Id
    @SequenceGenerator(name="train_seq",sequenceName="train_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="train_seq")
    @Column(name ="TRAINSTAFF_ID",unique = true, nullable = false)
    private @NotNull Long trainId;
    private @NotNull @Size(min=3) @Pattern(regexp = "^([A-z*0-9*ก-๙*' '])*") String trainName;
    private @NotNull @Size(min=5) @Pattern(regexp = "^([A-z*0-9*ก-๙*' '])*") String trainDescription;
    private @NotNull @Column(unique = true) Date trainDate;

    @ManyToOne
    @JoinColumn(name = "TIMEDURATION_ID", insertable = true)
    private TimeDuration trainTime;

    @ManyToOne
    @JoinColumn(name = "TRAINTYPE_ID", insertable = true)
    private TrainType trainType;

    @OneToOne
    @JoinColumn(name = "STAFF_ID", insertable = true)
    private Staff trainStaff;

}
