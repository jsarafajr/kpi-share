package ua.kpi.share.service;

import ua.kpi.share.domain.Task;
import ua.kpi.share.dto.TaskApply;

import java.util.List;

/**
 * Created by oleh on 23.05.2015.
 */
public interface TaskService {

    void create(Task task);

    void delete(int taskId);

    List<Task> getByUserId(int userId);

    Task getById(int id);

    List<Task> getAll();

    void applyTask(TaskApply taskApply);


}
