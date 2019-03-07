package com.se.team19.server.Entity;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;


@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "Stock")
public class Stock {

    @Id
    @SequenceGenerator(name="stock_seq",sequenceName="stock_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="stock_seq")
    @Column(name="stockId",unique = true, nullable = false)

    @NotNull
    private  Long stockId;
    @NotNull
    private  int amountTotal;
    @NotNull
    @Size(min = 4, max = 20)
    @Pattern(regexp = "^[A-Z]([A-z*0-9*' '])+|^([ก-๙*0-9*' '])+")
    @Column(unique = true)
    private  String productName;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Category.class)
    @JoinColumn(name = "categoryId")
    private Category categoryName;
}
