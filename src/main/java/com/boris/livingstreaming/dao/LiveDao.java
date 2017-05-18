package com.boris.livingstreaming.dao;

import com.boris.livingstreaming.model.LiveRoom;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Qloop on 2017/5/10.
 */
@Transactional
public interface LiveDao extends CrudRepository<LiveRoom, Long> {
    LiveRoom findByMail(String mail);

    LiveRoom findByNickname(String nickname);

    Iterable<LiveRoom> findAll(Sort orders);
}
