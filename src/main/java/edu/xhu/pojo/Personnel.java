package edu.xhu.pojo;

import lombok.Data;

/*
确诊病例实体类
 */
@Data
public class Personnel {

    private Integer empId;
    private String  empNum;
    private String  empName;
    private String  empDept_num;
    private String  empDept;
    private String  empEdu;
    private String  empGender;
    private String  empBirth;
    private String  empPost;

}
