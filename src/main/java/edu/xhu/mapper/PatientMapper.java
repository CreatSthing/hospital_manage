package edu.xhu.mapper;

import edu.xhu.pojo.Patient;

import java.util.List;
import java.util.Map;

public interface PatientMapper {
//    List<Patient> queryPerSonList(Map<String,Object> data);
    Integer countPerson(Map<String,Object> data);
    List<Patient> queryPersonListByPage(Map<String,Object> data);
    void deletePatient(Patient patient);
    void editPatient(Patient patient);
    //3.新增确诊病例
    Integer addPatient(Patient patient);
//    List<Patient> queryOnePerson(Patient patient);


}
