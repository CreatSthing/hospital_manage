package edu.xhu.pojo;

import lombok.Data;

@Data
public class Patient {
    private Integer paitient_id;
    private String paitient_name;
    private String paitient_gender;
    private String paitient_dateStart;
    private String paitient_dept;
    private String paitient_state;
    private String paitient_doc;
    private String paitient_room;
    private String paitient_bed;
}
