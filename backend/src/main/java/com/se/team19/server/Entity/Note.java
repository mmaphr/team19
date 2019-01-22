package com.se.team19.server.Entity;

import lombok.*;
import javax.persistence.*;

@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "Note")
public class Note {
    @Id
    @SequenceGenerator(name="note_seq",sequenceName="note_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="note_seq")
    @Column(name="noteId",unique = true, nullable = false)

    private  @NonNull Long noteId;
    private  @NonNull String noteName;

}
