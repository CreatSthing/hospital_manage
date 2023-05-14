package edu.xhu.service;

import edu.xhu.common.JsonResult;

public interface DocPatientService {
    JsonResult queryPersonListByPage(Integer page, Integer limit, String emp_no, String emp_name);
}
