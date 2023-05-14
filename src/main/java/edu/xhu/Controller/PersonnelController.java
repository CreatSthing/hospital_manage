package edu.xhu.Controller;

import edu.xhu.common.JsonResult;
import edu.xhu.common.R;
import edu.xhu.pojo.Personnel;
import edu.xhu.service.PersonnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Personnel")
public class PersonnelController {

    @Autowired
    private PersonnelService personnelService;

    @GetMapping("/queryByPage")
    public JsonResult queryPersonListByPage(Integer page, Integer limit, String name, String card_num){
        JsonResult jsonResult = personnelService.queryPersonListByPage(page,limit,name,card_num);
        return jsonResult;
    }

    @PostMapping("/addPersonnel")
    public R addPersonnel(Personnel personnel){
        R r = personnelService.addConfirm(personnel);
        System.out.println(personnel.getEmpGender());
        return r;
    }

    @GetMapping("/deletePersonnel")
    public R deletePersonnel(Personnel personnel){
        R r = personnelService.deletePersonnel(personnel);
        return r;
    }

    @GetMapping("/editPersonnel")
    public R editPersonnel(Personnel personnel){
        R r = personnelService.editPersonnel(personnel);
        return r;
    }
 }


