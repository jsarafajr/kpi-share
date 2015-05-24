package ua.kpi.share.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ua.kpi.share.domain.User;

import java.util.List;

/**
 * Created by oleh on 23.05.2015.
 */
public interface UserService extends UserDetailsService {

    User signUp(User user);

    User getById(int id);

    User getByEmail(String email);

    List<User> getAll();

    boolean verify(String email);
}
