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
    private @NotNull String expenses;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = TypeHealthCheck.class)
    @JoinColumn(name = "typeHealthCheck_ID", insertable = true)
    private @NotNull TypeHealthCheck HealthCheckType;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = DataOlder.class)
    @JoinColumn(name = "Dataolder_ID", insertable = true)
    private @NotNull DataOlder HealthCheckData;

    public HealthCheck() {}

    public HealthCheck(String hospital, Date datecheck, String expenses, TypeHealthCheck healthCheckType, DataOlder healthCheckData) {
        this.hospital = hospital;
        this.datecheck = datecheck;
        this.expenses = expenses;
        HealthCheckType = healthCheckType;
        HealthCheckData = healthCheckData;
    }

}
