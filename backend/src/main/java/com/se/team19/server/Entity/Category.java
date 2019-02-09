package com.se.team19.server.Entity;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

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

    @NotNull
    private Long categoryId;
    @NotNull
    @Size(min = 4, max = 20)
    @Pattern(regexp = "^[A-Z]([A-z*0-9*' '])+|^([ก-๙*0-9*' '])+")
    @Column(unique = true)
    private String categoryName;
}
