package edu.xhu.service.imp;

import edu.xhu.common.JsonResult;
import edu.xhu.common.R;
import edu.xhu.mapper.PatientMapper;
import edu.xhu.pojo.Patient;
import edu.xhu.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    PatientMapper patientMapper;

    JsonResult jsonResult = new JsonResult();

//    @Override
//    public JsonResult queryPerSonList(Integer page, Integer limits) {
//        Map<String,Object> data=new HashMap<>();
//        data.put("pageNow",(page-1)*limits);
//        data.put("pageSize",limits);
//        Integer totalSize= patientMapper.countPerson(data);
//        jsonResult.setCount(totalSize);
//        List<Patient> list= patientMapper.queryPerSonList(data);
//        jsonResult.setData(list);
//        if(jsonResult!=null){
//            jsonResult.setCode(0);
//            jsonResult.setMsg("查询成功");
//        }else{
//            jsonResult.setCode(500);
//            jsonResult.setMsg("Oh,you failed");
//
//        }
//
//        return jsonResult;
//    }

    @Override
    public JsonResult queryPersonListByPage(Integer page,Integer limit,Integer paitient_id,String paitient_name,String paitient_gender)
    {
        JsonResult jsonResult = new JsonResult();
        //调用mapper层
        //1.查询总记录数
        Map<String,Object> data = new HashMap<>();
        data.put("paitient_id",paitient_id);
        data.put("paitient_name",paitient_name);
        data.put("paitient_gender",paitient_gender);
        Integer totalSize = patientMapper.countPerson(data);
        jsonResult.setCount(totalSize);

         //2.分页查询确诊病例数据

        data.put("pageNow",(page-1)*limit);//每页起始的索引
        data.put("pageSize",limit);
        List<Patient> list = patientMapper.queryPersonListByPage(data);
        System.out.println(list);
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
//    @Override
//    public JsonResult queryOnePatient(Patient patient){
//        JsonResult jsonResult = new JsonResult();
//        List<Patient> list= patientMapper.queryOnePerson(patient);
//        jsonResult.setData(list);
//        if(jsonResult!=null){
            //查询成功
            //layui规定：数据表格要想成功显示数据，状态码code一定是0
//            jsonResult.setCode(0);
//            jsonResult.setMsg("查询成功");
//        }else{
//            //查询失败
//            jsonResult.setCode(500);
//            jsonResult.setMsg("系统开小差，请联系管理员");
//        }
//        return jsonResult;
//    }

    @Override
    public R addConfirm(Patient patient)
    {
        R r = new R();
        int result = patientMapper.addPatient(patient);
        if(result>0){
            r.setCode(200);
            r.setMsg("添加 确诊病例成功");
        }else{
            r.setCode(500);
            r.setMsg("系统开小差，请联系管理员");
        }
        return r;
    }
    @Override
    public R deletePatient(Patient patient){
        R r = new R();
         patientMapper.deletePatient(patient);
         return r;
    }
    @Override
    public R editPatient(Patient patient){
        R r = new R();
        patientMapper.editPatient(patient);
        return r;
    }


}
