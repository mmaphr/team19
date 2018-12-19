import lombok.*;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.*;

import java.util.*;
@Data
@Entity
@Getter @Setter
//@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name="roomimformation")
public class RoomImformation {
    @Id
    @SequenceGenerator(name="roomim_seq",sequenceName="roomim_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="roomim_seq")
    @Column(name="roomimformation_ID",unique = true, nullable = true)
    private @NonNull Long Id;
    private String RoomName;
    private String RoomStatus;
    private String TypeRoom;
    private String person;

//    @ManyToOne
//    @JoinColumn(name = "ROOM_ID")
//    private Room room;
//
//    @OneToOne
//    @JoinColumn(name="PROPOSAL_ID")
//    private Proposal proposal;

//    public Meeting(Long id) {
//        Id = id;
//    }

//    public Meeting() {}
//    public Meeting(String
//                           CallOther,Date Dates, String LandMark, String Telephone, String Text) {
//
//        this.CallOther = CallOther;
//        this.Dates = Dates;
//        this.Telephone = Telephone;
//        this.Text = Text;
//    }
}