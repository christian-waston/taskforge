package com.taskforge.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@Entity
@Table(name = "workstation")
@Data @NoArgsConstructor @AllArgsConstructor
public class Workstation {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    
    private int stationNumber;
    private String name;
    
    // No relationships - workstation knows nothing about its team member
}