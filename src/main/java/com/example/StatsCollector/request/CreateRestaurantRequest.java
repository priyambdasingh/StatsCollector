package com.example.StatsCollector.request;
import com.example.StatsCollector.model.ContactInformation;
import lombok.Data;
import com.example.StatsCollector.model.Adress;


import java.util.List;

@Data
public class CreateRestaurantRequest {
    private Long id;
    private String description;
    private String cuisineType;
    private Adress address;
    private ContactInformation contactInformation;
    private String opningHours;
    private List<String>images;
    private String name;
//    private LocalDateTime
}

