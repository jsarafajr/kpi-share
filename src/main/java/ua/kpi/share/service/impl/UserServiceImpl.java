package ua.kpi.share.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.kpi.share.domain.User;
import ua.kpi.share.repository.UserRepository;
import ua.kpi.share.service.UserService;

/**
 * Created by oleh on 23.05.2015.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public User signUp(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getById(int id) {
        return userRepository.findOne(id);
    }

    @Override
    public User getByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public boolean verify(String email) {
        return (userRepository.findByEmail(email)!=null);
    }
}
