package edu.xhu.service.imp;

import edu.xhu.common.JsonResult;
import edu.xhu.mapper.DocPatientMapper;
import edu.xhu.pojo.DocPatient;
import edu.xhu.service.DocPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DocPatientServiceImpl implements DocPatientService {

    @Autowired
    DocPatientMapper docpatientMapper;

    @Override
    public JsonResult queryPersonListByPage(Integer page, Integer limit, String emp_no, String emp_name)
    {
        JsonResult jsonResult = new JsonResult();
        //调用mapper层
        //1.查询总记录数


        Map<String,Object> data = new HashMap<>();
        data.put("emp_no",emp_no);
        data.put("emp_name",emp_name);
        Integer totalSize = docpatientMapper.countPerson(data);
        jsonResult.setCount(totalSize);
        //2.分页查询确诊病例数据

        data.put("pageNow",(page-1)*limit);//每页起始的索引
        data.put("pageSize",limit);
        List<DocPatient> list = docpatientMapper.queryDocPersonListByPage(data);
        jsonResult.setData(list);
        if(jsonResult!=null){
            //查询成功
            //layui规定：数据表格要想成功显示数据，状态码code一定是0
            jsonResult.setCode(0);
            jsonResult.setMsg("查询成功");
        }else{
            //查询失败
            jsonResult.setCode(500);
            jsonResult.setMsg("系统开小差，请联系管理员");
        }
        return jsonResult;
    }
}
