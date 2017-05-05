package com.boris.livingstreaming.dao;

import com.boris.livingstreaming.model.Feedback;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by Qloop on 2017/4/9.
 */
@Transactional
public interface FeedbackDao extends CrudRepository<Feedback, Long> {
    Feedback findById(long id);
    Iterable<Feedback> findByMail(String mail);
}
