package edu.xhu.service;

import edu.xhu.pojo.Appartus;
import edu.xhu.comon.JsonResult;
import edu.xhu.comon.R;

public interface appartusservice {
//    查询所有
   JsonResult getallappartus();
//   分页查询
   JsonResult queryByPage(int page,int limit);
//   增加仪器
   R addappartus(Appartus appartus);
//   删除仪器
   R deleteappartus(int id);
//   修改仪器
   R updateappartus(Appartus appartus);
//   id获取
  JsonResult getappartusbyid(int id);
//  编号获取
  JsonResult getappartusbyno(String no);
//  名称获取
  JsonResult getappartusbyname(String name);
//  名称和编号获取
  JsonResult Search(String no,String name);

}
