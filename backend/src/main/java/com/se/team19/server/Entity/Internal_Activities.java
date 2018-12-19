package th.sut.sa.demo.entity;

import lombok.*;
import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "Internal_Activities")
public class Internal_Activities {
    @Id
    @SequenceGenerator(name = "inAct_seq", sequenceName = "inAct_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "inAct_seq")
    @Column(name = "InAct_ID", unique = true, nullable = false)
    private @NonNull Long id;
    private String name;
    private String description;
    private Date date;
    private String person_name;
    private String staff_name;


}

