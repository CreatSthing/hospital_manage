package edu.xhu.mapper;

import edu.xhu.pojo.Appartus;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface AppartusMapper {
//    添加仪器
    Integer insert(Appartus appartus);
//    删除仪器
    Integer delete(int id);
//    按id查询仪器
    Appartus getbyid(int id);
//    修改仪器
     Integer update(Appartus appartus);
//    查询所有
    List<Appartus> getall();
//    分页
   List<Appartus> queryByPage(Map data);
// 所有条数
   int getcount();
//   按编号查询
    List<Appartus> getbyno(String no);
    //   按名称查询
    List<Appartus> getbyname(String name);
//    按名称和编号查询
List<Appartus> getbynameandno(@Param("no") String no, @Param("name") String name);

}
