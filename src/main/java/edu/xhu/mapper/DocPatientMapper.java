package edu.xhu.mapper;

import edu.xhu.pojo.DocPatient;

import java.util.List;
import java.util.Map;

public interface DocPatientMapper {
    Integer countPerson(Map<String,Object> data);
    List<DocPatient> queryDocPersonListByPage(Map<String,Object> data);
}
