package com.lessonscheduler.dao;

import com.lessonscheduler.domain.Schedule;
import org.springframework.stereotype.Repository;

/**
 * Created by Günay on 8.4.2017.
 */

@Repository
public class ScheduleDao extends GenericDao<Schedule> {

    public ScheduleDao() {
        super(Schedule.class);
    }

    public void removeAllSchedules() {
        entityManager.createNamedQuery("Schedule.removeAllSchedules").executeUpdate();
    }
}
