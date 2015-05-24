package ua.kpi.share.domain;

import ua.kpi.share.dto.TaskDto;

import javax.persistence.*;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by oleh on 23.05.2015.
 */
@Entity
@Table(name = "Task")
public class Task {
    private int id;
    private String title;
    private String subject;
    private String description;
    private List<Attachment> attachments;
    private User user;
    private Timestamp date;

    public static Task valueOf(TaskDto taskDto) {
        Task task = new Task();
        task.title = taskDto.getTitle();
        task.subject = taskDto.getSubject();
        task.description = taskDto.getDescription();

        return task;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Basic
    @Column(name = "date")
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "task_id")
    public List<Attachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "subject")
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
