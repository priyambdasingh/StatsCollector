package StatcCollector.example.StatcCollecto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.persistence.criteria.Order;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Data
@Table(name = "Stats_DTLS")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;
    private String name;
    private String address;
    private String foodPreference;
    private int familyMembers;
    private double latitude;
    private double longitude;
//    @JsonIgnore
//    @OneToMany(cascade = CascadeType.ALL,mappedBy = "customer")
//    private List<Order> orders = new ArrayList<Order>();
//    @ElementCollection
//    private List<RestorentDto> favorites = new ArrayList<RestorentDto>();
//    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
//    private List <Adress> addresses =new ArrayList<>();

}



