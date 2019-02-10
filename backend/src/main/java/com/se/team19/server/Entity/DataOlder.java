package com.se.team19.server.Entity;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@Entity
@Table(name = "DataOlder" ,uniqueConstraints = {@UniqueConstraint(columnNames = {"oldername","parentname"})})
public class DataOlder {
    @Id
    @SequenceGenerator(name = "dataolder_seq", sequenceName = "dataolder_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dataolder_seq")
    @Column(name = "Dataolder_ID", unique = true)
    @NotNull
    private  Long id;
    @NotNull
    @Size (min = 2,max = 40)
    @Pattern (regexp = "^[ก-๙' ']*")
    private String oldername;
    @NotNull
    @Temporal(TemporalType.DATE)
    private  Date olderbirth;
    @NotNull
    @Size (min = 2,max = 40)
    @Pattern (regexp = "^[ก-๙' ']*")
    private  String parentname;
    @NotNull
    @Size (min = 3,max = 7)
    @Pattern (regexp = "^[0-9]*[/][0-9]*")
    private  String parentaddress;
    @NotNull
    @Size (max = 10,min = 10)
    @Pattern(regexp = "^[0-9]*$")
    private  String parentphone;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Gender.class)
    @JoinColumn(name = "Gender_ID", insertable = true)
    @NotNull
    private Gender dataOlderGender;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Province.class)
    @JoinColumn(name = "Province_ID", insertable = true)
    @NotNull
    private Province dataOlderProvince;

    public DataOlder(){}
    public DataOlder(String oldername,  Date olderbirth, String parentname, String parentaddress, String parentphone, Gender dataOlderGender, Province dataOlderProvince) {
        this.oldername = oldername;
        this.olderbirth = olderbirth;
        this.parentname = parentname;
        this.parentaddress = parentaddress;
        this.parentphone = parentphone;
        this.dataOlderGender = dataOlderGender;
        this.dataOlderProvince = dataOlderProvince;
    }
}
