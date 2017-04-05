package com.lessonscheduler.service;

import com.lessonscheduler.dao.ClassRoomDao;
import com.lessonscheduler.domain.ClassRoom;
import com.lessonscheduler.dto.ClassRoomDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Onur on 4.4.2017.
 */

@Service
public class ClassRoomService {

    @Autowired
    ClassRoomDao classRoomDao;

    @Transactional(readOnly = true)
    public List<ClassRoomDto> getAllClassRooms() {

        List<ClassRoomDto> classRoomDtoList = new ArrayList<ClassRoomDto>();

        //Tüm sınıfları bul.
        List<ClassRoom> classRoomList = classRoomDao.findAll();

        for (ClassRoom classRoom : classRoomList) {
            classRoomDtoList.add(new ClassRoomDto(classRoom));
        }

        return classRoomDtoList;
    }

    @Transactional
    public void saveClassRoom(ClassRoomDto classRoomDto) {

        ClassRoom classRoom;

        if (classRoomDto.getId() == null) {
            classRoom = new ClassRoom();
        } else {
            classRoom = classRoomDao.find(classRoomDto.getId());
        }

        classRoom.setClassRoomNo(classRoomDto.getClassRoomNo());

        if (classRoomDto.getId() == null) {
            classRoomDao.persist(classRoom);
        } else {
            classRoomDao.merge(classRoom);
        }

    }

    @Transactional
    public void removeClassRoom(Integer clasRoomId) {

        if (clasRoomId != null) {
            ClassRoom classRoom = classRoomDao.find(clasRoomId);
            classRoomDao.remove(classRoom);
        }

    }

    @Transactional
    public ClassRoomDto findClasRoom(Integer classRoomId) {

        ClassRoom classRoom = classRoomDao.find(classRoomId);

        return new ClassRoomDto(classRoom);

    }
}
