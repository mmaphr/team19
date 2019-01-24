package com.se.team19.server.Entity;
import lombok.*;
import java.util.Date;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import org.springframework.format.annotation.DateTimeFormat;
@Data
@Entity
public class PeriodTime {
    @Id
    @SequenceGenerator(name="periodTime_seq",sequenceName="periodTime_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PeriodTime_seq")
    @Column(name="periodTime_id",unique = true)

    private @NonNull Long periodTime_id;
//    @DateTimeFormat(pattern = "HH:mm")
    private @NonNull String periodTime;//อาจใช้typ Date


    public PeriodTime (){}
    public PeriodTime(String periodTime){this.periodTime=periodTime;}


}
