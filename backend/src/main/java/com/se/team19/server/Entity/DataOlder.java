package com.se.team19.server.Entity;

import lombok.*;
import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "DataOlder")
public class DataOlder {
    @Id
    @SequenceGenerator(name = "dataolder_seq", sequenceName = "dataolder_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dataolder_seq")
    @Column(name = "DataOlder_ID", unique = true, nullable = false)
    private @NonNull Long id;
    private @NonNull String oldername;
    private @NonNull Date olderbirth;
    private @NonNull String parentname
    private @NonNull String parentaddress;
    private @NonNull String parentphone;

    //ความสัมพันธ์
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Gender.class)
    @JoinColumn(name = "Gender_ID", insertable = true)
    private Gender dataOlderGender;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Province.class)
    @JoinColumn(name = "Province_ID", insertable = true)
    private Province dataOlderProvince;

}
