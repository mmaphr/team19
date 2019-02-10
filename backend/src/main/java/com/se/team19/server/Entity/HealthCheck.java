package com.se.team19.server.Entity;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;

@Data
@Entity
@Table(name = "HealthCheck",uniqueConstraints = {@UniqueConstraint(columnNames = {"Dataolder_ID","datecheck"})})
public class HealthCheck {
    @Id
    @SequenceGenerator(name = "healthCheck_seq", sequenceName = "healthCheck_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "healthCheck_seq")
    @Column(name = "healthCheck_ID", unique = true)
    @NotNull
    private Long id;
    @NotNull
    @Size(min = 2,max = 40)
    @Pattern(regexp = "^[ก-๙' ']*")
    private  String hospital;
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date datecheck;
    @DecimalMin(value = "0")
    private int expenses;
    @NotNull
    @Size(max = 40)
    @Pattern (regexp = "^[ก-๙' 'a-zA-Z]*")
    private String description;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = TypeHealthCheck.class)
    @JoinColumn(name = "typeHealthCheck_ID", insertable = true)
    @NotNull
    private TypeHealthCheck healthCheckType;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = DataOlder.class)
    @JoinColumn(name = "Dataolder_ID", insertable = true)
    @NotNull
    private DataOlder healthCheckData;

    public HealthCheck() {}

    public HealthCheck( String hospital, Date datecheck, int expenses, String description, TypeHealthCheck healthCheckType, DataOlder healthCheckData) {
        this.hospital = hospital;
        this.datecheck = datecheck;
        this.expenses = expenses;
        this.description = description;
        this.healthCheckType = healthCheckType;
        this.healthCheckData = healthCheckData;
    }
}
