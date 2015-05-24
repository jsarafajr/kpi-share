package ua.kpi.share.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ua.kpi.share.domain.User;
import ua.kpi.share.service.UserService;

/**
 * Created by oleh on 24.05.2015.
 */
@RestController
public class HelloController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    @ResponseBody
    public User getUser() {

        User newUser = User.newUser("test1", "228", "lol");

        userService.signUp(newUser);

        System.out.println("here");

        return userService.getById(1);
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    public String getHello(){
        return "hello";
    }
}