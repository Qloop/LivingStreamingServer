package com.boris.livingstreaming.dao;

import com.boris.livingstreaming.model.UpdateInfo;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Qloop on 2017/4/10.
 */
public interface UpdateDao extends CrudRepository<UpdateInfo, Long> {
    Iterable<UpdateInfo> findAll();
}
