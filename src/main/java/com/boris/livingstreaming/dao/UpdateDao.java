package com.boris.livingstreaming.dao;

import com.boris.livingstreaming.model.UpdateInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Qloop on 2017/4/10.
 */
@Transactional
public interface UpdateDao extends CrudRepository<UpdateInfo, Long> {
    Iterable<UpdateInfo> findAll();
}
