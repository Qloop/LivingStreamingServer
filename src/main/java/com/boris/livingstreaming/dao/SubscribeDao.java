package com.boris.livingstreaming.dao;

import com.boris.livingstreaming.model.Subscribe;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Qloop on 2017/4/9.
 */
public interface SubscribeDao extends CrudRepository<Subscribe, Long> {
    Iterable<String> findBySubscriberId(long subscriberId);
}
