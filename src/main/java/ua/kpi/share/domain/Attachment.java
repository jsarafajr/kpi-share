package ua.kpi.share.domain;

import javax.persistence.Entity;
import javax.persistence.*;

/**
 * Created by oleh on 24.05.2015.
 */
@Entity
@Table(name = "Attachment")
public class Attachment {
    private int id;
    private String name;
    private String path;
    private Task task;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "path")
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_id")
    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}
