package edu.xhu.service.imp;

import edu.xhu.mapper.AppartusMapper;
import edu.xhu.pojo.Appartus;
import edu.xhu.comon.JsonResult;
import edu.xhu.comon.R;
import edu.xhu.service.appartusservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@Service
public class appartusserviceimp implements appartusservice {
    @Autowired
    private AppartusMapper appartusmapper;

//  layui中返回给前端数据表格需要呈现的data需要返回LIst类型
    @Override
    public JsonResult getallappartus() {
        JsonResult<List> jsonResult = new JsonResult<>();

        jsonResult.setData(appartusmapper.getall());
        if(jsonResult.getData()!=null){
            jsonResult.setCode(200);
            jsonResult.setMsg("查询成功");
        }else
        {
            jsonResult.setCode(500);
            jsonResult.setMsg("查询失败");
        }
   return jsonResult;
    }

    @Override
    public JsonResult queryByPage(int page,int limit) {
//        处理
        JsonResult<List> jsonResult = new JsonResult<>();
        HashMap<String, Integer> date = new HashMap<>();
        date.put("pageNow",(page-1)*limit);
        date.put("pageSize",limit);
        List<Appartus> appartusList = appartusmapper.queryByPage(date);
        jsonResult.setData(appartusList);
//        封装结果集
        if(jsonResult.getData()!=null){
            jsonResult.setCode(0);
            jsonResult.setMsg("查询成功");
        }else
        {
            jsonResult.setCode(500);
            jsonResult.setMsg("查询失败");
        }
//        返回
        return jsonResult;

    }

    @Override
    public R addappartus(Appartus appartus) {
        R<Object> r = new R<>();
        Integer res = appartusmapper.insert(appartus);
        if(res==1){
            r.setMsg("插入成功");
            r.setCode(200);
        }
        else {
            r.setCode(500);
            r.setMsg("插入失败");
        }
        return r;
    }

    @Override
    public R deleteappartus(int id) {
        R<Integer> r = new R<>();
        Integer res = appartusmapper.delete(id);
        r.setData(res);
        if(r.getData()==1){
            r.setCode(200);
            r.setMsg("删除成功");
        }else {
            r.setCode(500);
            r.setMsg("删除失败");
        }
        return r;

    }

    @Override
    public R updateappartus(Appartus appartus) {
        R<Integer> r = new R<>();
        Integer res = appartusmapper.update(appartus);
        r.setData(res);
        if (r.getData()==1){
            r.setMsg("修改成功");
            r.setCode(200);
        }else {
            r.setMsg("修改失败");
            r.setCode(500);
        }
        return r;
    }

    @Override
    public JsonResult<List> getappartusbyid(int id) {
        JsonResult<List> jsonResult = new JsonResult<>();
        ArrayList<Appartus> appartuses = new ArrayList<>();
        appartuses.add(appartusmapper.getbyid(id));
        jsonResult.setData(appartuses);
        jsonResult.setCount(appartusmapper.getcount());
        //        封装结果集
        if(jsonResult.getData()!=null){
            jsonResult.setCode(0);
            jsonResult.setMsg("查询成功");
        }else
        {
            jsonResult.setCode(500);
            jsonResult.setMsg("查询失败");
        }
//        返回
        return jsonResult;
    }

    @Override
    public JsonResult getappartusbyno(String no) {
        JsonResult<List> jsonResult = new JsonResult<>();
        jsonResult.setData(appartusmapper.getbyno(no));
        //        封装结果集
        if(jsonResult.getData()!=null){
            jsonResult.setCode(0);
            jsonResult.setMsg("查询成功");
        }else
        {
            jsonResult.setCode(500);
            jsonResult.setMsg("查询失败");
        }
//        返回
        return jsonResult;
    }

    @Override
    public JsonResult getappartusbyname(String name) {
        JsonResult<List> jsonResult = new JsonResult<>();
        jsonResult.setData(appartusmapper.getbyname(name));
        //        封装结果集
        if(jsonResult.getData()!=null){
            jsonResult.setCode(0);
            jsonResult.setMsg("查询成功");
        }else
        {
            jsonResult.setCode(500);
            jsonResult.setMsg("查询失败");
        }
//        返回
        return jsonResult;
    }

    public JsonResult Search(String no,String name){
        JsonResult<List> jsonResult = new JsonResult<>();
        if(no==""&&name!=""){
            jsonResult.setData(appartusmapper.getbyname(name));
            //        封装结果集
            if(jsonResult.getData()!=null){
                jsonResult.setCode(0);
                jsonResult.setMsg("查询成功");
            }else
            {
                jsonResult.setCode(500);
                jsonResult.setMsg("查询失败");
            }

        }
        else if(no!=""&&name=="")
        {
            jsonResult.setData(appartusmapper.getbyno(no));
            //        封装结果集
            if(jsonResult.getData()!=null){
                jsonResult.setCode(0);
                jsonResult.setMsg("查询成功");
            }else
            {
                jsonResult.setCode(500);
                jsonResult.setMsg("查询失败");
            }

        }
        else {
            jsonResult.setData(appartusmapper.getbynameandno(no,name));
            //        封装结果集
            if(jsonResult.getData()!=null){
                jsonResult.setCode(0);
                jsonResult.setMsg("查询成功");
            }else
            {
                jsonResult.setCode(500);
                jsonResult.setMsg("查询失败");
            }

        }

        return jsonResult;
    }


}
