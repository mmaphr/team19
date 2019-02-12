package com.se.team19.server.Entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
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
    private  Long Id;

    @NotNull
    @Pattern(regexp = "^([A-z*0-9*ก-๙*' '])*")
    private  String nameVisitor;

    @NotNull
    @Pattern(regexp = "^[0-9]{13}$")
    private String numIdVisitor;

    @NotNull
    private @Min(value = 1) int ageVisitor;

    @Pattern(regexp = "^[0][0-9]{9}$")
    @NotNull
    private String phoneVisitor;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date dayVisitor;

    @NotNull
    @Temporal(TemporalType.TIME)
    private Date timeVisitor;

    @NotNull
    private String addressVisitor;

    @ManyToOne
    @JoinColumn(name = "GENDER_ID", nullable = true)
    @NotNull
    private Gender genders;

    @ManyToOne
    @JoinColumn(name = "province_ID", nullable = true)
    @NotNull
    private Province province;

    @ManyToOne
    @JoinColumn(name = "RelativesStatus_ID", nullable = true)
    @NotNull
    private RelativesStatus relativesStatus;

    @ManyToOne
    @JoinColumn(name = "OLDERVISIT_ID", nullable = true)
    @NotNull
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
