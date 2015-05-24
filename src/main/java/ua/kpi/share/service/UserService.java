package ua.kpi.share.service;

import ua.kpi.share.domain.User;

/**
 * Created by oleh on 23.05.2015.
 */
public interface UserService {

    void signUp(User user);

    User getById(int id);

    User getByEmail(String email);

    boolean verify(String email);
}
