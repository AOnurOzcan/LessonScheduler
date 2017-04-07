package com.lessonscheduler.dto;

import com.lessonscheduler.domain.Lesson;

/**
 * Created by Onur on 6.4.2017.
 */
public class LessonDto {

    private Integer id;

    private String lessonName;

    private ClassRoomDto classRoom; //Dersin verildiği sınıf

    private UserDto user; //Dersi veren akademisyen

    public LessonDto() {
    }

    public LessonDto(Lesson lesson) {
        this.id = lesson.getId();
        this.lessonName = lesson.getLessonName();

        if (lesson.getClassRoom() != null) {
            this.classRoom = new ClassRoomDto(lesson.getClassRoom());
        }

        if (lesson.getUser() != null) {
            this.user = new UserDto(lesson.getUser());
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    public ClassRoomDto getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(ClassRoomDto classRoom) {
        this.classRoom = classRoom;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }
}
