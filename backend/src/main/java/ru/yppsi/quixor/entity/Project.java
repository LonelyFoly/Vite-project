package ru.yppsi.quixor.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_project", schema = "BASE")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Project {

    @Id
    private String shortName;

    private String name;

    @ManyToOne
    @JoinColumn(name = "creator_id")
    private User creator;
}
