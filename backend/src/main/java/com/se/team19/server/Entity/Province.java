package com.se.team19.server.Entity;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;

@Data
@Entity
@Table(name = "province")
public class Province {
    @Id
    @SequenceGenerator(name="province_seq",sequenceName="province_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="province_seq")
    @Column(name="PROVINCE_ID",unique = true, nullable = false)
    private @NonNull Long ProvinceId;
    private @NonNull String ProvinceName;

    public Province() {}

    public Province(String provinceName) {
        ProvinceName = provinceName;
    }
}
