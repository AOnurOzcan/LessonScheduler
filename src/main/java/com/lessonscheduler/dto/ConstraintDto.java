package com.lessonscheduler.dto;

import com.lessonscheduler.domain.Constraint;

/**
 * Created by Onur on 5.4.2017.
 */
public class ConstraintDto {

    private Integer id;

    private Integer availableDay; // 1-Pazartesi, 2-Salı ...

    private UserDto user;

    public ConstraintDto() {
    }

    public ConstraintDto(Constraint constraint) {
        this.id = constraint.getId();
        this.availableDay = constraint.getAvailableDay();
        this.user = new UserDto(constraint.getUser());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAvailableDay() {
        return availableDay;
    }

    public void setAvailableDay(Integer availableDay) {
        this.availableDay = availableDay;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }
}
