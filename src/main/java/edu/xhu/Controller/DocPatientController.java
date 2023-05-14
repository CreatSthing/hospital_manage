package edu.xhu.Controller;

import edu.xhu.common.JsonResult;
import edu.xhu.service.DocPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/docpatient_confirm")
public class DocPatientController {
    @Autowired
    private DocPatientService docpatientService;
    /*
     * 前端往后端传送当前页面和每页条数
     * 注意：只要数据表格开启了-page：true异地那个会传page和limit
     * 后端传前端：数据 总记录数 状态码 提示信息
     *
     * */

    @GetMapping("/queryByPage")
    public JsonResult queryPersonListByPage(Integer page, Integer limit, Integer paitient_id, String emp_no, String emp_name){
        System.out.println(emp_no);
        System.out.println(emp_name);

        JsonResult jsonResult = docpatientService.queryPersonListByPage(page, limit,emp_no,emp_name);

        return jsonResult;
    }


}
