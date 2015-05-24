package ua.kpi.share.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.kpi.share.domain.User;
import ua.kpi.share.repository.UserRepository;
import ua.kpi.share.service.UserService;

import java.util.HashSet;

/**
 * Created by oleh on 23.05.2015.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

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

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("User with email: " + email + " not found in database");
        }
        org.springframework.security.core.userdetails.User user1 =
                new org.springframework.security.core.userdetails.User(email, user.getPassword(),
                        new HashSet<GrantedAuthority>());
        return user1;
    }
}
