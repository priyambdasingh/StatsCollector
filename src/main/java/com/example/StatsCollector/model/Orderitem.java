//package com.example.StatsCollector.model;
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.util.List;
//@Entity
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//public class Orderitem {
//        @Id
//        @GeneratedValue(strategy = GenerationType.AUTO)
//        private Long id;
//        @ManyToOne
//        private Food food;
//        private  int quantity;
//        private Long totalPrice;
//        private List<String> ingredients;
//}
//
//
//
//

package com.example.StatsCollector.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JsonIgnore
    private Order order;

    @ManyToOne
    private Food food;

    private int quantity;
    private Long totalPrice;

    @ElementCollection
    @CollectionTable(name = "order_item_ingredients", joinColumns = @JoinColumn(name = "order_item_id"))
    @Column(name = "ingredient")
    private List<String> ingredients;
}

