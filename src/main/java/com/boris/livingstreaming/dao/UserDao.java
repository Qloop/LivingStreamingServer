package com.boris.livingstreaming.dao;

import com.boris.livingstreaming.model.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Qloop on 2017/4/9.
 */
@Transactional
public interface UserDao extends CrudRepository<User, Long> {
    User findById(long id);
    User findByMail(String mail);
    User findByNickname(String nickname);
    Iterable<User> findAll(Sort orders);
}
