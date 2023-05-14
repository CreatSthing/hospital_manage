package edu.xhu.service;

import edu.xhu.common.BedResult;
import edu.xhu.pojo.Bed;

import java.io.InputStream;

public interface BedService {
    BedResult searchByPage(Integer page, Integer limit,Integer bed_ID,String bed_num);
    BedResult bedAdd(Bed bed);
    BedResult bedDel(Bed bed);
    BedResult bedUpdate(Bed bed);
    BedResult getDataFromExcel(InputStream inputStream);

}
