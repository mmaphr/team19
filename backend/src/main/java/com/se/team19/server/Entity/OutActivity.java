package com.se.team19.server.Entity;

import lombok.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.util.Date;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.*;
import javax.persistence.SequenceGenerator;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.*;

@Data
@Entity
public class OutActivity {
    @Id
    @SequenceGenerator(name="activity_seq",sequenceName="activity_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="activity_seq")
    @Column(name="activity_id",unique = true)

    private @NotNull Long activity_id;
    private @NotNull  String nameActivity;
    private @NotNull String nameRequestor;
    @NotNull
    @Size(min = 10, max = 50)
    private  String descriptionActivity;
    @NotNull
    @Pattern(regexp = "^[0-9]{10}$")
    private String phonenum;
    @NotNull
    @Column(unique = true)
    private  Date date;

    @ManyToOne
    @JoinColumn(name="category_id")
    @NotNull
    private CategoryActivity categoryActivity;

    @ManyToOne
    @JoinColumn(name="periodTimeS_id")
    @NotNull
    private PeriodTime periodTimeS;

    @ManyToOne
    @JoinColumn(name="periodTimeE_id")
    @NotNull
    private PeriodTime periodTimeE;

   @OneToOne
   @JoinColumn(name="StaffId")
   @NotNull
    private Staff staff;


    @OneToOne
    @JoinColumn(name="organized_id")
    @NotNull
    private Organized organized;

    public OutActivity(){}

    public OutActivity(String nameActivity, String nameRequestor, String descriptionActivity, String phonenum, Date date, CategoryActivity categoryActivity, PeriodTime periodTimeS, PeriodTime periodTimeE, Organized organized,Staff staff) {
        this.nameActivity = nameActivity;
        this.nameRequestor = nameRequestor;
        this.descriptionActivity = descriptionActivity;
        this.phonenum = phonenum;
        this.date = date;
        this.categoryActivity = categoryActivity;
        this.periodTimeS = periodTimeS;
        this.periodTimeE = periodTimeE;
        this.organized = organized;
        this.staff = staff;
    }
}

