package ua.kpi.share.dto;

/**
 * Created by Evgeniy Baranuk on 24.05.15.
 */
public class UserDto {
    private String email;
    private String phone;
    private String name;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
