package edu.xhu.pojo;

import lombok.Data;

@Data
public class Dept {
    private Integer dept_id;
    private String dept_no;
    private String dept_name;
    private String dept_manager;
    private String dept_viceManager;
}
