package com.lessonscheduler.dao;

import com.lessonscheduler.domain.ClassRoom;
import org.springframework.stereotype.Repository;

/**
 * Created by Onur on 4.4.2017.
 */

@Repository
public class ClassRoomDao extends GenericDao<ClassRoom>{

    public ClassRoomDao() {
        super(ClassRoom.class);
    }
}
