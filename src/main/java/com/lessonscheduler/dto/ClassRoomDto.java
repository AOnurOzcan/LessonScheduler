package com.lessonscheduler.dto;

import com.lessonscheduler.domain.ClassRoom;

/**
 * Created by Günay on 4.4.2017.
 */
public class ClassRoomDto {

    private Integer id;

    private String classRoomNo;

    public ClassRoomDto(){}

    public ClassRoomDto(ClassRoom classRoom) {
        this.id = classRoom.getId();
        this.classRoomNo = classRoom.getClassRoomNo();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassRoomNo() {
        return classRoomNo;
    }

    public void setClassRoomNo(String classRoomNo) {
        this.classRoomNo = classRoomNo;
    }
}
