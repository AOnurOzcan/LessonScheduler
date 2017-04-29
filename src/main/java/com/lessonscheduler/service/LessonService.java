package com.lessonscheduler.service;

import com.lessonscheduler.dao.ClassRoomDao;
import com.lessonscheduler.dao.LessonDao;
import com.lessonscheduler.dao.UserDao;
import com.lessonscheduler.domain.ClassRoom;
import com.lessonscheduler.domain.Lesson;
import com.lessonscheduler.domain.User;
import com.lessonscheduler.dto.LessonDto;
import com.lessonscheduler.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Günay on 6.4.2017.
 */

@Service
public class LessonService {

    @Autowired
    LessonDao lessonDao;

    @Autowired
    UserDao userDao;

    @Autowired
    ClassRoomDao classRoomDao;

    @Autowired
    HttpSession httpSession;

    @Transactional(readOnly = true)
    public List<LessonDto> getAllLessons() {

        List<LessonDto> lessonDtoList = new ArrayList<LessonDto>();

        //Tüm dersleri bul.
        List<Lesson> lessonList = lessonDao.findAll();

        for (Lesson lesson : lessonList) {
            lessonDtoList.add(new LessonDto(lesson));
        }

        return lessonDtoList;
    }

    @Transactional
    public void saveLesson(LessonDto lessonDto) {

        Lesson lesson;
        ClassRoom classRoom;

        if (lessonDto.getId() == null) {
            lesson = new Lesson();
        } else {
            lesson = lessonDao.find(lessonDto.getId());
        }

        classRoom = classRoomDao.find(lessonDto.getClassRoom().getId());
        lesson.setLessonName(lessonDto.getLessonName());
        lesson.setClassRoom(classRoom);
        lesson.setLessonTime(lessonDto.getLessonTime());

        if (lessonDto.getId() == null) {
            lessonDao.persist(lesson);
        } else {
            lessonDao.merge(lesson);
        }

    }

    @Transactional
    public void removeLesson(Integer lessonId) {

        if (lessonId != null) {
            Lesson lesson = lessonDao.find(lessonId);
            lessonDao.remove(lesson);
        }

    }

    @Transactional
    public LessonDto findLesson(Integer constraintId) {

        Lesson lesson = lessonDao.find(constraintId);

        return new LessonDto(lesson);

    }

    @Transactional(readOnly = true)
    public List<LessonDto> findNotChosenLessons() {
        List<LessonDto> lessonDtoList = new ArrayList<LessonDto>();
        List<Lesson> lessonList;
        UserDto userDto = (UserDto) httpSession.getAttribute("user");

        lessonList = lessonDao.findNotChosenLessons(userDto.getId());

        for (Lesson lesson : lessonList) {
            lessonDtoList.add(new LessonDto(lesson));
        }

        return lessonDtoList;
    }

    @Transactional
    public void saveMultiLesson(List<LessonDto> lessonDtoList) {

        Lesson lesson;
        User user;

        for (LessonDto lessonDto : lessonDtoList) {
            lesson = lessonDao.find(lessonDto.getId());

            if (lessonDto.getUser().getId() != null) {
                user = userDao.find(lessonDto.getUser().getId());
                lesson.setUser(user);
            } else {
                lesson.setUser(null);
            }

            lessonDao.merge(lesson);

        }

    }

}
