package edu.xhu.Controller;

import edu.xhu.common.JsonResult;
import edu.xhu.common.R;
import edu.xhu.pojo.Patient;
import edu.xhu.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/patient_confirm")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping("/queryByPage")
    public JsonResult queryPersonListByPage(Integer page,Integer limit,Integer paitient_id,String paitient_name,String paitient_gender){
       System.out.println(paitient_id);
        System.out.println(paitient_name);
        System.out.println(paitient_gender);
       JsonResult jsonResult = patientService.queryPersonListByPage(page, limit,paitient_id,paitient_name,paitient_gender);

        return jsonResult;
    }

    @PostMapping("/addPatient")
    public R addConfirm(Patient patient){
        R r = patientService.addConfirm(patient);
        return r;
    }

    @GetMapping("/deletePatient")
    public R deletePatient(Patient patient){
        R r = patientService.deletePatient(patient);
        return r;
    }
    @GetMapping("/editPatient")
    public R editPatient(Patient patient){
        R r = patientService.editPatient(patient);
        return r;
    }


}
