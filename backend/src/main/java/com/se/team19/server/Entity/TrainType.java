package com.se.team19.server.Entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "trainType")
public class TrainType {
    @Id
    @SequenceGenerator(name="train_seq",sequenceName="train_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="train_seq")
    @Column(name ="TRAIN_ID",unique = true, nullable = false)
    private @NotNull Long typeid;
    private @NotNull String typeName;

    public TrainType(String typeName) {
        this.typeName = typeName;
    }
}
