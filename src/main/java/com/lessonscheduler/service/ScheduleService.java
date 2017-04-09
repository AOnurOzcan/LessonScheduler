package com.lessonscheduler.service;

import com.lessonscheduler.dao.ConstraintDao;
import com.lessonscheduler.dao.LessonDao;
import com.lessonscheduler.dao.ScheduleDao;
import com.lessonscheduler.domain.Constraint;
import com.lessonscheduler.domain.Lesson;
import com.lessonscheduler.domain.Schedule;
import com.lessonscheduler.dto.ScheduleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Onur on 8.4.2017.
 */

@Service
public class ScheduleService {

    @Autowired
    ScheduleDao scheduleDao;

    @Autowired
    LessonDao lessonDao;

    @Autowired
    ConstraintDao constraintDao;

    @Transactional
    public void createSchedule() {

        Map<Integer, Lesson> mondaySchedule = new HashMap<Integer, Lesson>();
        Map<Integer, Lesson> tuesdaySchedule = new HashMap<Integer, Lesson>();
        Map<Integer, Lesson> wednesdaySchedule = new HashMap<Integer, Lesson>();
        Map<Integer, Lesson> thursdaySchedule = new HashMap<Integer, Lesson>();
        Map<Integer, Lesson> fridaySchedule = new HashMap<Integer, Lesson>();

        List<Map<Integer, Lesson>> scheduleList = new ArrayList<Map<Integer, Lesson>>();
        scheduleList.add(mondaySchedule);
        scheduleList.add(tuesdaySchedule);
        scheduleList.add(wednesdaySchedule);
        scheduleList.add(thursdaySchedule);
        scheduleList.add(fridaySchedule);

        List<Lesson> placedLessons = new ArrayList<Lesson>();

        List<Lesson> lessonList = lessonDao.findAll();
        List<Constraint> constraintList = constraintDao.findAll();

        for (int i = 0; i < 5; i++) {
            for (int hour = 9; hour < 24; hour++) {
                scheduleList.get(i).put(hour, null);
            }
        }

        for (int day = 1; day < 6; day++) {
            for (Lesson lesson : lessonList) {
                //Hoca müsait mi?
                if (teacherIsAvailable(lesson.getUser().getId(), day, constraintList)) {
                    Integer lessonStartTime = teacherHasAnotherLesson(lesson.getUser().getId(), lesson, scheduleList.get(day - 1));

                    //Ders yerleştirmek için uygun zaman var ise
                    if (!lessonStartTime.equals(-1)) {
                        placedLessons.add(lesson);

                        Schedule schedule = new Schedule();
                        schedule.setDay(day);
                        schedule.setStartTime(lessonStartTime);
                        schedule.setEndTime(lessonStartTime + lesson.getLessonTime());
                        schedule.setLesson(lesson);
                        scheduleDao.persist(schedule);

                        for (int j = lessonStartTime; j < lessonStartTime + lesson.getLessonTime(); j++) {
                            scheduleList.get(day - 1).put(j, lesson);
                        }
                    }
                }
            }

            //Her bir gün için yerleştirilen dersleri ders listesinden sil.
            lessonList.removeAll(placedLessons);
            //Yerleştirilen dersler listesini temizle.
            placedLessons.clear();
        }

    }

    private boolean teacherIsAvailable(Integer teacherId, Integer day, List<Constraint> constraints) {

        boolean isAvailable = false;

        for (Constraint constraint : constraints) {
            if (constraint.getUser().getId().equals(teacherId)) {
                if (constraint.getAvailableDay().equals(day)) {
                    isAvailable = true;
                    break;
                }
            }
        }

        return isAvailable;
    }

    private Integer teacherHasAnotherLesson(Integer teacherId, Lesson lesson, Map<Integer, Lesson> schedule) {

        Integer lessonStartTime;

        //Günün 9'dan 24'e kadar tüm saatlerini dön
        for (int hour = 9; hour < 24; hour++) {
            lessonStartTime = hour;

            //Bir ders ile karşılaşırsa
            if (schedule.get(hour) != null) {

                //Yerleştireceğimiz dersin başlangıç saatini belirle
                lessonStartTime = hour + schedule.get(hour).getLessonTime() - 1;

                //Eğer yerleştireceğimiz ders ile yerleştirilmiş dersin hocaları aynı ise üzerine dersler arası süreyi ekle
                if (schedule.get(hour).getUser().getId().equals(teacherId)) {
                    lessonStartTime += schedule.get(hour).getUser().getLessonInterval();
                }

                hour = lessonStartTime;

            } else {
                //Ekleyeceğimiz dersin bitiş süresi 24'ü geçmediğini kontrol et
                boolean lessonFinishTimeLessThan24 = lessonStartTime + lesson.getLessonTime() < 24;
                boolean lessonExists = false;

                //Dersin bitiş süresi 24'ü aşmıyorsa
                if (lessonFinishTimeLessThan24) {

                    //Dersin başlangıcı ile bitişi arasında zaman dilimini dön
                    for (int k = lessonStartTime; k < lessonStartTime + lesson.getLessonTime(); k++) {

                        //Ders var ise
                        if (schedule.get(k) != null) {
                            lessonExists = true;
                            //Hour değişkenini var olan dersin bitiş saatinden itibaren devam edecek şekilde değiştir.
                            hour = k + schedule.get(k).getLessonTime();
                            break;
                        }

                    }

                    //Dersin başlangıcıyla bitişi arasında bir ders yok ise dersi yerleştir
                    if (!lessonExists) {
                        return lessonStartTime;
                    }

                } else {
                    return -1;
                }
            }
        }

        return -1;
    }

    @Transactional(readOnly = true)
    public List<ScheduleDto> getSchedule() {
        List<ScheduleDto> scheduleDtos = new ArrayList<ScheduleDto>();

        List<Schedule> schedules = scheduleDao.findAll();

        for (Schedule schedule : schedules) {
            scheduleDtos.add(new ScheduleDto(schedule));
        }

        return scheduleDtos;
    }

}
