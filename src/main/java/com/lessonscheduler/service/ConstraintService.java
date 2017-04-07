package com.lessonscheduler.service;

import com.lessonscheduler.dao.ConstraintDao;
import com.lessonscheduler.dao.UserDao;
import com.lessonscheduler.domain.Constraint;
import com.lessonscheduler.domain.User;
import com.lessonscheduler.dto.ConstraintDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Onur on 5.4.2017.
 */

@Service
public class ConstraintService {

    @Autowired
    ConstraintDao constraintDao;

    @Autowired
    UserDao userDao;

    @Transactional(readOnly = true)
    public List<ConstraintDto> getAllConstraints() {

        List<ConstraintDto> constraintDtoList = new ArrayList<ConstraintDto>();

        //Tüm kısıtları bul.
        List<Constraint> constraintList = constraintDao.findAll();

        for (Constraint constraint : constraintList) {
            constraintDtoList.add(new ConstraintDto(constraint));
        }

        return constraintDtoList;
    }

    @Transactional
    public void saveConstraint(ConstraintDto constraintDto) {

        Constraint constraint;
        User user;

        if (constraintDto.getId() == null) {
            constraint = new Constraint();
            user = userDao.find(constraintDto.getUser().getId());
            constraint.setUser(user);
        } else {
            constraint = constraintDao.find(constraintDto.getId());
        }

        constraint.setAvailableDay(constraintDto.getAvailableDay());

        if (constraintDto.getId() == null) {
            constraintDao.persist(constraint);
        } else {
            constraintDao.merge(constraint);
        }

    }

    @Transactional
    public void removeConstraint(Integer constraintId) {

        if (constraintId != null) {
            Constraint constraint = constraintDao.find(constraintId);
            constraintDao.remove(constraint);
        }

    }

    @Transactional
    public ConstraintDto findConstraint(Integer constraintId) {

        Constraint constraint = constraintDao.find(constraintId);

        return new ConstraintDto(constraint);

    }

}
