package ua.kpi.share.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.kpi.share.domain.Task;

import java.util.List;

/**
 * Created by oleh on 23.05.2015.
 */
public interface TaskRepository extends JpaRepository<Task, Integer> {

    List<Task> findAll();

    List<Task> findByUserId(int userId);
}
