package edu.xhu.service.imp;

import edu.xhu.common.JsonResult;
import edu.xhu.common.R;
import edu.xhu.mapper.PersonnelMapper;
import edu.xhu.pojo.Personnel;
import edu.xhu.service.PersonnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PersonnelServiceImpl implements PersonnelService {

    @Autowired
    private PersonnelMapper personnelMapper;

    JsonResult jsonResult = new JsonResult();

    @Override
    public JsonResult queryPersonListByPage(Integer page, Integer limit, String name, String card_num) {
        JsonResult jsonResult = new JsonResult();
        //调用mapper层
        //1.查询总记录数
        Map<String,Object> data = new HashMap<>();
        data.put("name",name);
        data.put("card_num",card_num);
        data.put("pageNow",(page-1)*limit);//每页起始的索引
        data.put("pageSize",limit);
        Integer totalSize = personnelMapper.countPerson(data);
        jsonResult.setCount(totalSize);
        //2.分页查询确诊病例数据
        List<Personnel> list = personnelMapper.queryPersonListByPage(data);
        jsonResult.setData(list);
        if(jsonResult!=null){
            //查询成功
            jsonResult.setCode(0);
            jsonResult.setMsg("查询成功");
        }else{
            //查询失败
            jsonResult.setCode(500);
            jsonResult.setMsg("系统开小差，请联系管理员");
        }
        return jsonResult;
    }



    @Override
    public R addConfirm(Personnel personnel) {
        R r = new R();
        int result = personnelMapper.addPersonnel(personnel);
        if(result>0){
            r.setCode(200);
            r.setMsg("添加员工信息成功");
        }else{
            r.setCode(500);
            r.setMsg("系统开小差，请联系管理员");
        }
        return r;
    }

    @Override
    public R deletePersonnel(Personnel personnel){
        R r = new R();
        int result =personnelMapper.deletePersonnel(personnel);
        if(result>0){
            r.setCode(200);
            r.setMsg("删除成功");
        }else{
            r.setCode(500);
            r.setMsg("系统开小差，请联系管理员");
        }
        return r;
    }

    @Override
    public R editPersonnel(Personnel personnel){
        R r = new R();
        personnelMapper.editPersonnel(personnel);
        return r;
    }
}
