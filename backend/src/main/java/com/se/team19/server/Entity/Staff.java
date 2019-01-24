package com.se.team19.server.Entity;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "staff")
public class Staff {
    @Id
    @SequenceGenerator(name="staff_seq",sequenceName="staff_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="staff_seq")
    @Column(name ="STAFF_ID",unique = true, nullable = false)
    private @NonNull Long staffId;
    private @NonNull String staffName;
    private @NonNull int age;
    private @NonNull String address;
    private @NonNull String phone;
    private @NonNull String username;
    private @NonNull String password;

    @ManyToOne()
    @JoinColumn(name = "GENDER_ID", insertable = true)
    private Gender staffGender;

    @ManyToOne()
    @JoinColumn(name = "PROVINCE_ID", insertable = true)
    private Province staffProvince;

    @ManyToOne()
    @JoinColumn(name = "POSITION_ID", insertable = true)
    private Position staffPosition;


}
