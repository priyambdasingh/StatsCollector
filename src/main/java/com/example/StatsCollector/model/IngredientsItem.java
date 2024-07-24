package com.example.StatsCollector.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class IngredientsItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @ManyToOne

    private IngredientCategory category;
    @JsonIgnore
    @ManyToOne
    private Restaurant restaurant;
    @ManyToOne
    private Food food;
    private boolean inStoke=true;
    }




