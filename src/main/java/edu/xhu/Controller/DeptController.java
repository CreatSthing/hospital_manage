package edu.xhu.Controller;

import edu.xhu.common.JsonResult;
import edu.xhu.common.R;
import edu.xhu.pojo.Dept;
import edu.xhu.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dept_sys")
public class DeptController {

    @Autowired
    private DeptService deptService;
    /*
     * 前端往后端传送当前页面和每页条数
     * 注意：只要数据表格开启了-page：true异地那个会传page和limit
     * 后端传前端：数据 总记录数 状态码 提示信息
     *
     * */
    @GetMapping("/search")
    public JsonResult searchDept(Integer page, Integer limit, String dept_no, String dept_name, String dept_manager, String dept_viceManager){
        JsonResult jsonResult = deptService.searchDept(page, limit, dept_no, dept_name);
        return jsonResult;
    }


    @GetMapping("/queryByPage")
    public JsonResult queryDeptListByPage(Integer page, Integer limit){
        JsonResult jsonResult = deptService.queryDeptListByPage(page, limit);
        return jsonResult;
    }

    @PostMapping("/addDept")
    public R addDept(Dept dept){
        R r = deptService.addDept(dept);
        return r;
    }

    @PostMapping("/delDept")
    public R delDeptById(Integer id){
        R r = deptService.delDeptById(id);
        return r;
    }
    //编辑
    @PostMapping("/updateDept")
    public R updateDeptById(Dept dept){
        R r = deptService.updateDeptById(dept);
        return r;
    }

    /*
    导出到Excel表格
     */
    @GetMapping("/export")
    public R exportDeptList(){
        R r = deptService.exportDeptList();
        return r;
    }

    /*
    把Excel表格数据导入
     */
    @PostMapping("/import")
    public R importDept(){
        R r = deptService.importDept();
        return r;
    }


}
