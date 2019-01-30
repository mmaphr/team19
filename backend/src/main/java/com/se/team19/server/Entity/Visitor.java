package com.se.team19.server.Entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.*;

@Data
@Entity
@Getter @Setter

@ToString
@EqualsAndHashCode
@Table(name="Visitor")
public class Visitor {
    @Id
    @SequenceGenerator(name="visitor_seq",sequenceName="visitor_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="visitor_seq")
    @Column(name="Visitor_ID",unique = true, nullable = true)
    private @NonNull Long Id;
    private @NonNull String nameVisitor;
    private @NonNull String numIdVisitor;
    private @NonNull int ageVisitor;
    private @NonNull String phoneVisitor;
    @Temporal(TemporalType.DATE)
//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private @NonNull Date dayVisitor;
    @Temporal(TemporalType.TIME)
    private @NonNull Date timeVisitor;
    private @NonNull String addressVisitor;

    @ManyToOne
    @JoinColumn(name = "GENDER_ID", nullable = true)
    private Gender genders;

    @ManyToOne
    @JoinColumn(name = "province_ID", nullable = true)
    private Province province;

    @ManyToOne
    @JoinColumn(name = "RelativesStatus_ID", nullable = true)
    private RelativesStatus relativesStatus;

    @ManyToOne
    @JoinColumn(name = "OLDERVISIT_ID", nullable = true)
    private DataOlder olders;




    public Visitor() {}
    public Visitor(String nameVisitor,String numIdVisitor,
                   int ageVisitor,String phoneVisitor,Date dayVisitor,Date timeVisitor,
                   String addressVisitor,Gender genders,Province province,
                   RelativesStatus relativesStatus,DataOlder olders) {
        this.nameVisitor = nameVisitor;
        this.numIdVisitor = numIdVisitor;
        this.ageVisitor = ageVisitor;
        this.phoneVisitor = phoneVisitor;
        this.dayVisitor = dayVisitor;
        this.timeVisitor = timeVisitor;
        this.addressVisitor = addressVisitor;
        this.genders = genders;
        this.province = province;
        this.relativesStatus = relativesStatus;
        this.olders = olders;


    }
}
