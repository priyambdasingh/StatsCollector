package StatcCollector.example.StatcCollecto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private Long price;
    @ManyToOne
    private Category foodCategory;
    @Column(length=1000)
    @ElementCollection
    private List<String> images;
    private boolean available;
    @OneToMany
    private Restaurant restaurant;
    private boolean isVegetarian;
    private boolean isNonvegtarian;
    @ManyToOne
    private List<IngredientsItem> ingredients=new ArrayList<>();
    private Data creationDate;
}



