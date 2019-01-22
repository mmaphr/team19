package com.se.team19.server.Entity;

import lombok.*;
import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "Province")
public class Province {
    @Id
    @SequenceGenerator(name = "province_seq", sequenceName = "province_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "province_seq")
    @Column(name = "Province_ID", unique = true, nullable = false)
    private @NonNull Long id;
    private @NonNull String provincename;

}
