package ua.kpi.share;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Evgeniy Baranuk on 20.05.15.
 */
@SpringBootApplication
public class Application extends SpringBootServletInitializer {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

    @Controller
    static class Routes {
        @RequestMapping({
                "/",
                "/list"
        })
        public String index() {
            return "forward:/index.html";
        }
    }
}
