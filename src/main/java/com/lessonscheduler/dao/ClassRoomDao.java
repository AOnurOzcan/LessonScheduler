package com.lessonscheduler.dao;

import com.lessonscheduler.domain.ClassRoom;
import org.springframework.stereotype.Repository;

/**
 * Created by Günay on 4.4.2017.
 */

@Repository
public class ClassRoomDao extends GenericDao<ClassRoom>{

    public ClassRoomDao() {
        super(ClassRoom.class);
    }
}
