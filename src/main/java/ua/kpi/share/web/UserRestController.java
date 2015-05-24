package ua.kpi.share.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ua.kpi.share.domain.User;
import ua.kpi.share.dto.UserDto;
import ua.kpi.share.service.UserService;

import javax.websocket.server.PathParam;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * Created by Evgeniy Baranuk on 24.05.15.
 */
@Controller
@RequestMapping("/api")
public class UserRestController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user", method = POST)
    public void registerUser(@RequestBody UserDto userDto) {
        userService.signUp(User.valueOf(userDto));
    }

    @RequestMapping(value = "/user", method = GET, params = {"id"})
    public void getUser(@RequestParam int id) {
        userService.getById(id);
    }

    @RequestMapping(value = "/user", method = GET, params = {"email"})
    public void getUser(@RequestParam String email) {
        userService.getByEmail(email);
    }


}
