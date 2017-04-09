package com.lessonscheduler.dao;

import com.lessonscheduler.domain.Schedule;
import org.springframework.stereotype.Repository;

/**
 * Created by Onur on 8.4.2017.
 */

@Repository
public class ScheduleDao extends GenericDao<Schedule> {

    public ScheduleDao() {
        super(Schedule.class);
    }

}