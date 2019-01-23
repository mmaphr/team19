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
@Table(name = "Stock")
public class Stock {

    @Id
    @SequenceGenerator(name="stock_seq",sequenceName="stock_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="stock_seq")
    @Column(name="Stock_Id",unique = true, nullable = false)

    private  @NonNull Long stockID;



}
