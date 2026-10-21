package com.taskforge.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "task")
@Data @NoArgsConstructor @AllArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    
    private LocalDate dueDate;
    
    @Enumerated(EnumType.STRING)
    private TaskStatus status;
    
    private String title;
    private int priority;
    
    // Many-to-One with Project
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Project project;
    
    // Many-to-One with TeamMember
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_member_id")
    private TeamMember teamMember;
}