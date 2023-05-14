package edu.xhu.mapper;


import edu.xhu.pojo.Bed;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface BedMapper {

    List<Bed> researchByPage(Map<String,Object> data);
    Integer Sizes(Map<String,Object> data);
    Integer insert(Bed bed);
    Integer delect(Bed bed);
    Integer update(Bed bed);


}
