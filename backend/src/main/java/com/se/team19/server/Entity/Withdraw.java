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
@Table(name = "Withdraw")
public class Withdraw {

    @Id
    @SequenceGenerator(name="withdraw_seq",sequenceName="withdraw_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="withdraw_seq")
    @Column(name="withdrawId",unique = true, nullable = false)

    @NotNull
    private  Long withdrawId;
    @NotNull
    private  String withdrawName;
    @NotNull
    @Positive
    private  int withdrawAmount;
    @NotNull
    @Column(unique = true)
    private  Date withdrawDate;

    @NotNull
    @Size(min = 10, max = 50)
    @Pattern(regexp = "^[A-Z]([A-z*0-9*' '])+|^([ก-๙*0-9*' '])+")
    private  String withdrawDescrition;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Department.class)
    @JoinColumn(name = "departmentId")
    private Department departmentName;

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
