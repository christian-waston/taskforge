package com.taskforge.model;

import jakarta.persistence.Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "skill")
@Data
@AllArgsConstructor 
@NoArgsConstructor
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    private String name;

    @ManyToMany (mappedBy = "skills")
    @JsonIgnore
    private List<TeamMember> teamMembers = new ArrayList<>();

}
