package com.se.team19.server.Entity;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "AddProducts")
public class AddProducts {
    @Id
    @SequenceGenerator(name="addProducts_seq",sequenceName="addProducts_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="addProducts_seq")
    @Column(name="addProductId",unique = true, nullable = false)

    @NotNull
    private   Long addProductId;
    @NotNull
    @Size(min = 4, max = 20)
    @Pattern(regexp = "^[A-Z]([A-z*0-9*' '])+|^([ก-๙*0-9*' '])+")
    private   String addProductName;
    @NotNull
    @Positive
    private   int addAmount;
    @NotNull
    @Column(unique = true)
    private   Date addDate;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Note.class)
    @JoinColumn(name = "noteId")
    private Note noteName;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Category.class)
    @JoinColumn(name = "categoryId")
    private Category categoryName;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Staff.class)
    @JoinColumn(name = "staff_id")
    private Staff staffName;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Stock.class)
    @JoinColumn(name = "stockId")
    private Stock stockName;
}
