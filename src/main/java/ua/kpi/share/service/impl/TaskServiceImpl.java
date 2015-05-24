package ua.kpi.share.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.kpi.share.domain.Task;
import ua.kpi.share.domain.User;
import ua.kpi.share.dto.TaskApply;
import ua.kpi.share.repository.TaskRepository;
import ua.kpi.share.repository.UserRepository;
import ua.kpi.share.service.EmailService;
import ua.kpi.share.service.TaskService;
import ua.kpi.share.utils.HTMLMessageBuilder;

import javax.swing.text.html.HTMLDocument;
import java.util.List;

/**
 * Created by oleh on 23.05.2015.
 */
@Service
public class TaskServiceImpl implements TaskService{
    @Autowired
    TaskRepository taskRepository;
    @Autowired
    EmailService emailService;
    @Autowired
    HTMLMessageBuilder htmLmessageBuilder;
    @Autowired
    UserRepository userRepository;

    @Override
    public void create(Task task) {
        taskRepository.save(task);
    }

    @Override
    public void delete(int taskId) {
        taskRepository.delete(taskId);
    }

    @Override
    public List<Task> getByUserId(int userId) {
        return taskRepository.findByUserId(userId);
    }

    @Override
    public Task getById(int id) {
        return taskRepository.findOne(id);
    }

    @Override
    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    @Override
    public void applyTask(TaskApply taskApply) {
        User applier = userRepository.findOne(taskApply.getUserId());
        if(applier == null) return;
        Task task = taskRepository.findOne(taskApply.getTaskId());
        if(task == null) return;

        HTMLDocument htmlDocument = htmLmessageBuilder.applyMessage(applier, taskApply,task);
        emailService.send(task.getUser().getEmail(), htmlDocument);
    }
}
