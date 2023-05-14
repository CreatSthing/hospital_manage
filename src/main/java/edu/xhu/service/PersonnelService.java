package edu.xhu.service;

import edu.xhu.common.JsonResult;
import edu.xhu.common.R;
import edu.xhu.pojo.Personnel;

public interface PersonnelService {
    JsonResult queryPersonListByPage(Integer page, Integer limit, String name, String card_num);

    R addConfirm(Personnel personnel);
    R deletePersonnel(Personnel personnel);
    R editPersonnel(Personnel personnel);
}
