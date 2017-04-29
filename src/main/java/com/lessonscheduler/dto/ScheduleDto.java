package com.lessonscheduler.dto;

import com.lessonscheduler.domain.Schedule;

/**
 * Created by Günay on 8.4.2017.
 */
public class ScheduleDto {

    private Integer id;

    private LessonDto lesson;

    private Integer startTime;

    private Integer endTime;

    private Integer day;  // 1-Pazartesi, 2-Salı ...

    public ScheduleDto() {

    }

    public ScheduleDto(Schedule schedule) {
        this.id = schedule.getId();
        this.lesson = new LessonDto(schedule.getLesson());
        this.startTime = schedule.getStartTime();
        this.endTime = schedule.getEndTime();
        this.day = schedule.getDay();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LessonDto getLesson() {
        return lesson;
    }

    public void setLesson(LessonDto lesson) {
        this.lesson = lesson;
    }

    public Integer getStartTime() {
        return startTime;
    }

    public void setStartTime(Integer startTime) {
        this.startTime = startTime;
    }

    public Integer getEndTime() {
        return endTime;
    }

    public void setEndTime(Integer endTime) {
        this.endTime = endTime;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }
}
