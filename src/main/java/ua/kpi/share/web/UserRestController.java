package ua.kpi.share.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ua.kpi.share.domain.User;
import ua.kpi.share.dto.UserDto;
import ua.kpi.share.service.UserService;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * Created by Evgeniy Baranuk on 24.05.15.
 */
@RestController
@RequestMapping("/api")
public class UserRestController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "user/register", method = POST)
    public void registerUser(@RequestBody UserDto userDto) {
        userService.signUp(User.valueOf(userDto));
    }

    @RequestMapping(value = "user", method = GET, params = {"id"})
    public User getUser(@RequestParam int id) {
        return userService.getById(id);
    }

    @RequestMapping(value = "user", method = GET, params = {"email"})
    public User getUser(@RequestParam String email) {
        return userService.getByEmail(email);
    }

    @RequestMapping(value = "/user/list")
    public List<User> list() {
        return userService.getAll();
    }
}
