package com.se.team19.server.Entity;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Entity
@Table(name = "HealthCheck")
public class HealthCheck {
    @Id
    @SequenceGenerator(name = "healthCheck_seq", sequenceName = "healthCheck_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "healthCheck_seq")
    @Column(name = "healthCheck_ID", unique = true, nullable = false)
    private @NotNull Long id;
    private @NotNull String hospital;
    private @NotNull Date datecheck;
    private @NotNull int expenses;
    private @NotNull String description;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = TypeHealthCheck.class)
    @JoinColumn(name = "typeHealthCheck_ID", insertable = true)
    private @NotNull TypeHealthCheck healthCheckType;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = DataOlder.class)
    @JoinColumn(name = "Dataolder_ID", insertable = true)
    private @NotNull DataOlder healthCheckData;

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
