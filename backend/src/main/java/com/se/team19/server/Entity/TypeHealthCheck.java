package com.se.team19.server.Entity;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Entity
@Table(name = "TypeHealthCheck")
public class TypeHealthCheck {
    @Id
    @SequenceGenerator(name = "typeHealthCheck_seq", sequenceName = "typeHealthCheck_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "typeHealthCheck_seq")
    @Column(name = "typeHealthCheck_ID", unique = true, nullable = false)
    private @NotNull Long id;
    private @NotNull String typename;

    public TypeHealthCheck(){}

    public TypeHealthCheck(String typename) {
        this.typename = typename;
    }
}
