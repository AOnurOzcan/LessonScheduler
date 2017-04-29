package com.lessonscheduler.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Günay on 4.4.2017.
 */

@Entity
@Table(name = "CLASSROOM")
public class ClassRoom implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "id_Sequence")
    @SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
    @Column(name = "CLASSROOM_ID")
    private Integer id;

    @Column(name = "CLASSROOM_NO")
    private String classRoomNo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassRoomNo() {
        return classRoomNo;
    }

    public void setClassRoomNo(String classRoomNo) {
        this.classRoomNo = classRoomNo;
    }
}
