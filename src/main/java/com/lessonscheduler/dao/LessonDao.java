package com.lessonscheduler.dao;

import com.lessonscheduler.domain.Lesson;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Günay on 6.4.2017.
 */

@Repository
public class LessonDao extends GenericDao<Lesson> {

    public LessonDao() {
        super(Lesson.class);
    }

    public List<Lesson> findNotChosenLessons(Integer userId) {
        TypedQuery<Lesson> query = entityManager.createNamedQuery("Lesson.findNotChosenLessons", Lesson.class);
        query.setParameter("userId", userId);
        return query.getResultList();
    }

    public List<Lesson> findLessonsTeacherSpecified() {
        TypedQuery<Lesson> query = entityManager.createNamedQuery("Lesson.findLessonsTeacherSpecified", Lesson.class);
        return query.getResultList();
    }
}
