package com.lessonscheduler.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Onur on 4.4.2017.
 */

@Entity
@Table(name = "USERACCOUNT")
@NamedQueries({
        @NamedQuery(name = "User.findByUsername", query = "select u from User u where u.username = ?1"),
        @NamedQuery(name = "User.findByUsernameAndPassword", query = "select u from User u where u.username = :username and u.password = :password")
})
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "id_Sequence")
    @SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
    @Column(name = "USER_ID")
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "ACCOUNT_TYPE")
    private Integer accountType; //0: Akademisyen, 1: Yönetici

    @Column(name = "LESSON_INTERVAL")
    private Integer lessonInterval;

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
