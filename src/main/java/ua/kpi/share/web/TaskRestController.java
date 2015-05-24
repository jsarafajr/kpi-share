package ua.kpi.share.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import ua.kpi.share.domain.Task;
import ua.kpi.share.domain.User;
import ua.kpi.share.dto.TaskDto;
import ua.kpi.share.service.TaskService;
import ua.kpi.share.service.UserService;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Evgeniy Baranuk on 24.05.15.
 */
@RestController
@RequestMapping("/api")
public class TaskRestController {
    @Autowired
    private UserService userService;

    @Autowired
    private TaskService taskService;

    @RequestMapping(value = "task", method = RequestMethod.POST)
    @ResponseBody
    public void addTask(@RequestBody TaskDto taskDto) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        User user = userService.getByEmail(username);

        Task task = Task.valueOf(taskDto);
        task.setUser(user);
        task.setDate(new Timestamp(new Date().getTime()));

        taskService.create(task);
    }

    @RequestMapping(value = "task/apply", method = RequestMethod.POST)
    @ResponseBody
    public void applyTask(@RequestParam("id") int taskId) {
        // todo
    }

    @RequestMapping("task/list")
    @ResponseBody
    public List<TaskDto> taskList() {
        // trash
        List<Task> tasks = taskService.getAll();
        List<TaskDto> taskDtos = new ArrayList<TaskDto>(tasks.size());

        for (Task task : tasks) {
            taskDtos.add(TaskDto.valueOf(task));
        }

        return taskDtos;
    }
}
