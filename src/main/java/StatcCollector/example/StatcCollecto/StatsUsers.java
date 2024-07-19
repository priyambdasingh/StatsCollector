package StatcCollector.example.StatcCollecto;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
    @Entity
    @NoArgsConstructor
    @Getter
    @Setter
    @Data
    @Table(name = "Stats_DTLS")
    public class StatsUsers {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long ID;
        private String name;
        private String address;
        private String foodPreference;
        private int familyMembers;
        private double latitude;
        private double longitude;


    }


