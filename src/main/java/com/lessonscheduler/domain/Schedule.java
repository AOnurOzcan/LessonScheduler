package com.lessonscheduler.domain;

import javax.persistence.*;

/**
 * Created by Onur on 8.4.2017.
 */

@Entity
@Table(name = "SCHEDULE")
@NamedQueries({
        @NamedQuery(name = "Schedule.removeAllSchedules", query = "DELETE from Schedule")
})
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "id_Sequence")
    @SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
    @Column(name = "CONSTRAINT_ID")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "LESSON_ID")
    private Lesson lesson;

    @Column(name = "START_TIME")
    private Integer startTime;

    @Column(name = "END_TIME")
    private Integer endTime;

    @Column(name = "DAY")
    private Integer day;  // 1-Pazartesi, 2-Salı ...

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
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
