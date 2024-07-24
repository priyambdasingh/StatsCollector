package com.example.StatsCollector.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

//@Entity
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//public class Cartitem {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//    @ManyToOne
//    @JsonIgnore
//    private Cart cart;
//    @ManyToOne
//    private Food food;
//    private int quantity;
//    private List<String> ingredients;
//    private Long totalPrice;
//
//}
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cartitem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Cart cart;
    @ManyToOne
    private Food food;
    private int quantity;
    private List<String> ingredients;
    private Long totalPrice;
}








