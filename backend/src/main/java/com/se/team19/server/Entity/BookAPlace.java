package com.se.team19.server.Entity;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Entity
public class BookAPlace {
    @Id
    @SequenceGenerator(name="bookaplace_seq",sequenceName="bookaplace_seq")
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="bookaplace_seq")
    @Column(name="bookaplace_id",unique = true)


    @NonNull private  Long bookaplace_id;

    @NotNull
    @Pattern(regexp = "^[0-9]{13}$")
    @Column(unique = true)
    private  String cardid;

    @NotNull
    @Pattern(regexp = "^[A-Z]([A-z*0-9*' '])+|^([ก-๙*0-9*' '])+")
    private String nameCaretaker;

    @NotNull
    @Pattern(regexp = "^[0-9]{10}$")
    private String phonCaretaker;

    @NotNull
    @Pattern(regexp = "^[A-Z]([A-z*0-9*' '])+|^([ก-๙*0-9*' '])+")
    private String namePlace;
    
    @NotNull
    @Size (min=10,max=50)
    @Pattern(regexp = "^[A-Z]([A-z*0-9*' '])+|^([ก-๙*0-9*' '])+")
    private String descriptionPlace;

    @ManyToOne
    @JoinColumn(name="activity_id")
    @NotNull
    private OutActivity outActivity;

    @ManyToOne
    @JoinColumn(name="place_id")
    @NotNull
    private PlaceTy placeTy;

    public BookAPlace() {
    }

    public BookAPlace(String cardid, String nameCaretaker, String phonCaretaker, String namePlace, String descriptionPlace, OutActivity outActivity) {
        this.cardid = cardid;
        this.nameCaretaker = nameCaretaker;
        this.phonCaretaker = phonCaretaker;
        this.namePlace = namePlace;
        this.descriptionPlace = descriptionPlace;
        this.outActivity = outActivity;
    }
}
