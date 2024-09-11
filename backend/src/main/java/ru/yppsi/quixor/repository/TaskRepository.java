package ru.yppsi.quixor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.yppsi.quixor.entity.Project;
import ru.yppsi.quixor.entity.Task;

import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    Long countByProject(Project project);

    Optional<Task> findByProjectAndNumber(Project project, Long number);
}
