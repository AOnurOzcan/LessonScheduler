package com.lessonscheduler.dao;

import com.lessonscheduler.domain.Constraint;
import org.springframework.stereotype.Repository;

/**
 * Created by Onur on 5.4.2017.
 */

@Repository

public class ConstraintDao extends GenericDao<Constraint>{

    public ConstraintDao() {
        super(Constraint.class);
    }

}
