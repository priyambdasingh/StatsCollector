//package com.example.StatsCollector.model;
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.util.ArrayList;
//import java.util.List;
//@NoArgsConstructor
//@AllArgsConstructor
//@Data
//@Entity
//public class Food {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//    private String name;
//    private String description;
//    private Long price;
//   @ManyToOne
//    private Category foodCategory;
//    @Column(length=1000)
//    @ElementCollection
//    private List<String> images;
//    private boolean available;
// @ManyToOne
//    private Restaurant restaurant;
//    private boolean isVegetarian;
//    private boolean isNonvegtarian;
//    @OneToMany
//
//    private List<IngredientsItem> ingredients=new ArrayList<>();
//    private Data creationDate;
//
//
//    }
//
//
package com.example.StatsCollector.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private Long price;

    @ManyToOne
    private Category foodCategory;

    @ElementCollection
    @CollectionTable(name = "food_images", joinColumns = @JoinColumn(name = "food_id"))
    @Column(name = "image")
    private List<String> images = new ArrayList<>();

    private boolean available;

    @ManyToOne
    private Restaurant restaurant;

    private boolean isVegetarian;
    private boolean isNonVegetarian;

    @OneToMany(mappedBy = "food", cascade = CascadeType.ALL)
    private List<IngredientsItem> ingredients = new ArrayList<>();

    private java.util.Date creationDate;
}

