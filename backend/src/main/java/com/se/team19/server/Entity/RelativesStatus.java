package com.se.team19.server.Entity;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import java.util.Date;

@Data
@Entity
@Getter @Setter
//@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name="RelativesStatus")
public class RelativesStatus {
    @Id
    @SequenceGenerator(name="relative_seq",sequenceName="relative_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="relative_seq")
    @Column(name="RelativesStatusId",unique = true, nullable = true)
    private @NonNull Long id;
    private @NonNull String relative;

    public RelativesStatus() {}
    public RelativesStatus(String relative) {
        this.relative = relative;
    }

}
