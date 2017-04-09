package com.lessonscheduler.dao;

import com.lessonscheduler.domain.Constraint;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Onur on 5.4.2017.
 */

@Repository

public class ConstraintDao extends GenericDao<Constraint> {

    public ConstraintDao() {
        super(Constraint.class);
    }

    public List<Constraint> findAllConstraintsByUser(Integer userId) {
        TypedQuery<Constraint> query = entityManager.createNamedQuery("Constraint.findAllConstraintsByUser", Constraint.class);
        query.setParameter("userId", userId);
        return query.getResultList();
    }

}
