package edu.xhu.mapper;

import edu.xhu.pojo.Personnel;

import java.util.List;
import java.util.Map;


public interface PersonnelMapper {

    //List<Personnel> queryPerSonList(Map<String,Object> data);
    Integer countPerson(Map<String, Object> data);
    List<Personnel> queryPersonListByPage(Map<String, Object> data);
    Integer deletePersonnel(Personnel personnel);
    void editPersonnel(Personnel personnel);
    //3.新增确诊病例
    Integer addPersonnel(Personnel personnel);

}
