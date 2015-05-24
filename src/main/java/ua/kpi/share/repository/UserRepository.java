package ua.kpi.share.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.kpi.share.domain.User;

import java.util.List;

/**
 * Created by oleh on 23.05.2015.
 */
public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findAll();

    User findByEmail(String email);
}
