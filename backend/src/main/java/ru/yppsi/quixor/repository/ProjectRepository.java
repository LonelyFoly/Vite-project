package ru.yppsi.quixor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.yppsi.quixor.entity.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, String> {
}
