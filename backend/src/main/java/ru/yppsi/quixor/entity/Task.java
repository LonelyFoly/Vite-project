package ru.yppsi.quixor.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "T_TASK", schema = "BASE")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = Project.class)
    @JoinColumn(name = "project_short_name")
    private Project project;

    private Long number;

    private String status;

    private String title;

    private String description;

    private LocalDate dueDate;

    @ManyToOne
    @JoinColumn(name = "creator_id")
    private User creator;
}

