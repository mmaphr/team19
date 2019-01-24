package com.example.demo.entity;

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
import java.util.*;

@Data
@Entity
public class OutActivity {
    @Id
    @SequenceGenerator(name="activity_seq",sequenceName="activity_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="activity_seq")
    @Column(name="activity_id",unique = true)

    private @NonNull Long activity_id;
    private @NonNull String nameActivity;
    private @NonNull String nameRequestor;
    private @NonNull String descriptionActivity;
    private @NonNull String phonenum;
    private @NonNull Date date;
//
    @ManyToOne
    @JoinColumn(name="category_id")
    private CategoryActivity categoryActivity;

    @ManyToOne
    @JoinColumn(name="periodTimeS_id")
    private PeriodTime periodTimeS;

    @ManyToOne
    @JoinColumn(name="periodTimeE_id")
    private PeriodTime periodTimeE;

   @OneToOne
   @JoinColumn(name="Staff_id")
    private Staff staff;


    @OneToOne
    @JoinColumn(name="organized_id")
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

