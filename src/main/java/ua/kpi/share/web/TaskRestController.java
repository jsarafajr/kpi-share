package ua.kpi.share.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import ua.kpi.share.domain.Task;
import ua.kpi.share.domain.User;
import ua.kpi.share.dto.TaskDto;
import ua.kpi.share.service.EmailService;
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

    @Autowired
    private EmailService emailService;

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
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        User userClient = userService.getByEmail(username);

        Task clickedTask = taskService.getById(taskId);
        final User addresseeUser = clickedTask.getUser();
        List<String> emailsToSend = new ArrayList<String>() {{
            add(addresseeUser.getEmail());
        }};
        emailService.sendText((String[])emailsToSend.toArray(), "KPI-share, Task request",
                "Yo, " + addresseeUser.getName() + "!\n" +
                "You've got a request for your task " + clickedTask.getTitle() + ".\n" +
                "To remind you, here is the task description : " + clickedTask.getDescription() +
                "\nPlease contact " + userClient.getName() + " Via email : " + userClient.getEmail() +
                " Or contact by phone : " + userClient.getPhone() +
                ".\n Thank you being with us!");
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
