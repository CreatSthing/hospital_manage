package edu.xhu.service;

import edu.xhu.common.JsonResult;
import edu.xhu.common.R;
import edu.xhu.pojo.Dept;

public interface DeptService {
    JsonResult queryDeptListByPage(Integer page, Integer limit);

    JsonResult searchDept(Integer page, Integer limit, String dept_no, String dept_name);

    R addDept(Dept dept);

    R delDeptById(Integer id);

    R updateDeptById(Dept dept);

    R exportDeptList();

    R importDept();
}
