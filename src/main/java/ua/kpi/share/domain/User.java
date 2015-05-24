package ua.kpi.share.domain;

import ua.kpi.share.dto.UserDto;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Evgeniy Baranuk on 23.05.15.
 */
@Entity
@Table(name = "User")
public class User {
    private int id;
    private String email;
    private String phone;
    private String name;
    private String password;
    private List<Task> tasks;

    private User(String email, String phone, String name) {
        this.email = email;
        this.phone = phone;
        this.name = name;
    }

    public static User newUser(String email, String phone, String name) {
        return new User(email, phone, name);
    }

    public static User valueOf(UserDto userDto) {
        return new User(userDto.getEmail(), userDto.getPhone(), userDto.getName());
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
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @OneToMany()
    @JoinColumn(name = "user_id")
    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
