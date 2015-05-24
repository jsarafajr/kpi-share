package ua.kpi.share.dto;

import ua.kpi.share.domain.Task;

import java.sql.Timestamp;

/**
 * Created by Evgeniy Baranuk on 24.05.15.
 */
public class TaskDto {
    private String user;
    private Timestamp date;
    private String title;
    private String subject;
    private String description;

    public static TaskDto valueOf(Task task) {
        TaskDto taskDto = new TaskDto();
        taskDto.user = task.getUser().getName();
        taskDto.date = task.getDate();
        taskDto.title = task.getTitle();
        taskDto.subject = taskDto.getSubject();
        taskDto.description = taskDto.getDescription();

        return taskDto;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }
}
