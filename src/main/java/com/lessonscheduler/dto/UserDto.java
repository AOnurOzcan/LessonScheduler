package com.lessonscheduler.dto;

import com.lessonscheduler.domain.User;

/**
 * Created by Onur on 4.4.2017.
 */
public class UserDto {

    private Integer id;

    private String name;

    private String username;

    private String password;

    private Integer accountType; //0: Öğretmen, 1: Yönetici

    private Integer lessonInterval;

    public UserDto() {
    }

    public UserDto(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.accountType = user.getAccountType();
        this.lessonInterval = user.getLessonInterval();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAccountType() {
        return accountType;
    }

    public void setAccountType(Integer accountType) {
        this.accountType = accountType;
    }

    public Integer getLessonInterval() {
        return lessonInterval;
    }

    public void setLessonInterval(Integer lessonInterval) {
        this.lessonInterval = lessonInterval;
    }
}
