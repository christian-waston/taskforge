package com.taskforge.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "project")
@Data @NoArgsConstructor @AllArgsConstructor
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    
    private String projectName;
    private String clientName;
    
    @Column(unique = true)
    private String projectCode;
    
    private String description;
    
    // Inverse side of One-to-Many with Task
    @OneToMany(mappedBy = "project")
    @JsonIgnore
    private List<Task> tasks = new ArrayList<>();
}