package edu.xhu.mapper;

import edu.xhu.pojo.potion;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface potionMapper {
//    添加仪器
    Integer insert(potion appartus);
//    删除仪器
    Integer delete(int id);
//    按id查询仪器
    potion getbyid(int id);
//    修改仪器
     Integer update(potion appartus);
//    查询所有
    List<potion> getall();
//    分页
   List<potion> queryByPage(Map data);
// 所有条数
   int getcount();
//   按编号查询
    List<potion> getbyno(String no);
    //   按名称查询
    List<potion> getbyname(String name);
//    按名称和编号查询
List<potion> getbynameandno(@Param("no") String no, @Param("name") String name);

}
