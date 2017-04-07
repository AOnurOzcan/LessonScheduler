package com.lessonscheduler.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Onur on 5.4.2017.
 */

@Entity
@Table(name = "CONSTRAINT")
public class Constraint implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "id_Sequence")
    @SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
    @Column(name = "CONSTRAINT_ID")
    private Integer id;

    @Column(name = "AVAILABLE_DAY")
    private Integer availableDay; // 1-Pazartesi, 2-Salı ...

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
