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
@Table(name="TypeRoom")
public class TypeRoom {
    @Id
    @SequenceGenerator(name="typename_seq",sequenceName="typename_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="typename_seq")
    @Column(name="TYPEROOM_ID",unique = true, nullable = true)
    private @NonNull Long id;
    private @NonNull String typeroom;

    public TypeRoom() {}
    public TypeRoom(String typeroom) {
        this.typeroom = typeroom;
    }

}