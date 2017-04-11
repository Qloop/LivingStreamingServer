package com.boris.livingstreaming.dao;

import com.boris.livingstreaming.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Qloop on 2017/4/9.
 */
public interface UserDao extends CrudRepository<User, Long> {

}
