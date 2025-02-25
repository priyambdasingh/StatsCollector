package com.example.StatsCollector.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Adress {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;

        private String street;
        private String city;
        private String state;
        private String postalCode;
    }


