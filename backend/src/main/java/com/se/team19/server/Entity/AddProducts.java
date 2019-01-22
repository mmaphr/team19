package com.se.team19.server.Entity;

import lombok.*;
import javax.persistence.*;
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

    private  @NonNull Long addProductId;
    private  @NonNull String addProductName;
    private  @NonNull Long addAmount;
    private  @NonNull Date addDate;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Note.class)
    @JoinColumn(name = "noteId")
    private Note noteName;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Category.class)
    @JoinColumn(name = "categoryId")
    private Category categoryName;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Staff.class)
    @JoinColumn(name = "staff_id")
    private Staff staffName;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Stock.class)
    @JoinColumn(name = "stockId")
    private Stock stockName;
}
