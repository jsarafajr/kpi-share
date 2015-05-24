package ua.kpi.share.domain;

import javax.persistence.*;
import javax.persistence.Table;
import java.security.Timestamp;
import java.util.List;

/**
 * Created by oleh on 23.05.2015.
 */
@Entity
@Table(name = "Task")
public class Task {
    private int id;
    private String header;
    private List<Attachment> attachments;
    private User user;
    private Timestamp date;

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
    @Column(name = "header")
    public String getHeader() {
        return header;
    }


    public void setHeader(String header) {
        this.header = header;
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
}
