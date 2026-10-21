package com.taskforge.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "team_member")
@Data @NoArgsConstructor @AllArgsConstructor
public class TeamMember {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    
    private String firstName;
    private String lastName;
    private String email;
    
    // Many-to-One with Workstation (nullable)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "workstation_id")
    private Workstation workstation;
    
    // Many-to-Many with Skill (Owning side)
    @ManyToMany
    @JoinTable(
        name = "team_member_skill",
        joinColumns = @JoinColumn(name = "team_member_id"),
        inverseJoinColumns = @JoinColumn(name = "skill_id")
    )
    private List<Skill> skills = new ArrayList<>();
    
    // Inverse side of One-to-Many with Task
    @OneToMany(mappedBy = "teamMember")
    @JsonIgnore
    private List<Task> tasks = new ArrayList<>();
}