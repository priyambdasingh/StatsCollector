//package com.example.StatsCollector.model;
//
//import com.example.StatsCollector.dto.RestaurantDto;
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import jakarta.persistence.*;
//import lombok.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Entity
//@NoArgsConstructor
//@AllArgsConstructor
//@Data
//@Table(name = "users")
//public class Users {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long ID;
//    private String name;
//    private String address;
//    private String foodPreference;
//    private int familyMembers;
//    private double latitude;
//    private double longitude;
//    private USER_ROLE role;
//
//    @JsonIgnore
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
//    private List<Order> orders = new ArrayList<>();
//
//    @ElementCollection
//    private List<RestaurantDto> favorites = new ArrayList<>();
//
//    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Adress> addresses = new ArrayList<>();
//}
package com.example.StatsCollector.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String email;
    private String password;
    private String name;
    private String address;
    private String foodPreference;
    private int familyMembers;
    private double latitude;
    private double longitude;
    @Enumerated(EnumType.STRING)
    private USER_ROLE role=USER_ROLE.ROLE_CUSTOMER;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Order> orders = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "user_favorites", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "favorite")
    private List<String> favorites = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "user_id")
    private List<Adress> addresses = new ArrayList<>();
}
