package com.se.team19.server.Entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "Staff")
public class Staff {
    @Id
    @SequenceGenerator(name="staff_seq",sequenceName="staff_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="staff_seq")
    @Column(name ="STAFF_ID",unique = true, nullable = false)
    private @NotNull Long staffId;
    private @NotNull @Pattern(regexp = "^([A-z*0-9*ก-๙*' '])*") String staffName;
    private @NotNull @Min(value = 18) int age;
    private @NotNull @Pattern(regexp = "^([A-z*0-9*ก-๙*' '*/])*") String address;
    private @NotNull @Size(min=10,max=10)@Pattern(regexp = "^[0][0-9]*$") String phone;
    private @NotNull @Column(unique = true) @Size(min=5,max=5) @Pattern(regexp = "^[HS][0-9]*$")String username;
    private @NotNull @Size(min=3)String password;

    @ManyToOne()
    @JoinColumn(name = "GENDER_ID", insertable = true)
    private @NotNull Gender staffGender;

    @ManyToOne()
    @JoinColumn(name = "PROVINCE_ID", insertable = true)
    private @NotNull Province staffProvince;

    @ManyToOne()
    @JoinColumn(name = "POSITION_ID", insertable = true)
    private @NotNull Position staffPosition;

    public Staff(String staffName,int age, String address, String phone, String username, String password, Gender staffGender, Province staffProvince, Position staffPosition) {
        this.staffName = staffName;
        this.age = age;
        this.address = address;
        this.phone = phone;
        this.username = username;
        this.password = password;
        this.staffGender = staffGender;
        this.staffProvince = staffProvince;
        this.staffPosition = staffPosition;
    }
}
