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
@Table(name = "Category")
public class Category {
    @Id
    @SequenceGenerator(name="category_seq",sequenceName="category_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="category_seq")
    @Column(name="categoryId",unique = true, nullable = false)

    private  @NonNull Long categoryId;
    private  @NonNull String categoryName;

}
