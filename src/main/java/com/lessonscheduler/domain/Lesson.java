package com.lessonscheduler.domain;

import javax.persistence.*;

/**
 * Created by Günay on 6.4.2017.
 */

@Entity
@Table(name = "LESSON")
@NamedQueries({
        @NamedQuery(name = "Lesson.findNotChosenLessons", query = "select l from Lesson l where l.user is null or l.user.id = :userId"),
        @NamedQuery(name = "Lesson.findLessonsTeacherSpecified", query = "select l from Lesson l where l.user is not null")
})
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "id_Sequence")
    @SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
    @Column(name = "LESSON_ID")
    private Integer id;

    @Column(name = "LESSON_NAME")
    private String lessonName;

    @OneToOne
    @JoinColumn(name = "CLASSROOM_ID")
    private ClassRoom classRoom; //Dersin verildiği sınıf

    @OneToOne
    @JoinColumn(name = "TEACHER_ID")
    private User user; //Dersi veren akademisyen

    @Column(name = "LESSON_TIME")
    private Integer lessonTime;

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

    public ClassRoom getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(ClassRoom classRoom) {
        this.classRoom = classRoom;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getLessonTime() {
        return lessonTime;
    }

    public void setLessonTime(Integer lessonTime) {
        this.lessonTime = lessonTime;
    }
}
