package edu.xhu.service;

import edu.xhu.common.JsonResult;
import edu.xhu.common.R;
import edu.xhu.pojo.Patient;

public interface PatientService {
//   JsonResult queryPerSonList(Integer page,Integer limits);
   JsonResult queryPersonListByPage(Integer page,Integer limit,Integer paitient_id,String paitient_name,String paitient_gender);

   R addConfirm(Patient patient);
   R deletePatient(Patient patient);
   R editPatient(Patient patient);
//   JsonResult queryOnePatient(Patient patient);



}
