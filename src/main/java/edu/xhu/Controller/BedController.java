package edu.xhu.Controller;
import edu.xhu.common.BedResult;
import edu.xhu.pojo.Bed;
import edu.xhu.service.BedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@RestController
@RequestMapping("/bed")
public class BedController {

    @Autowired
    BedService bedService;

    @GetMapping("/research")
    public BedResult searchByPage(Integer page,Integer limit,Integer bed_ID,String bed_num){

        BedResult bedResult=bedService.searchByPage(page,limit,bed_ID,bed_num);

        return bedResult;
    }
    @PostMapping("/insert")
    public BedResult bedAdd(Bed bed){
        BedResult bedResult=bedService.bedAdd(bed);
        System.out.println(bedResult);
        return bedResult;

    }

    @GetMapping("/delete")
    public  BedResult bedDel(Bed bed){

        BedResult bedResult=bedService.bedDel(bed);
        return bedResult;
    }
    @PostMapping("/update")
    public BedResult rowMsg(Bed bed){
        BedResult bedResult=bedService.bedUpdate(bed);
        return bedResult;
    }

    @PostMapping("/import")
    public BedResult excleimport(@RequestParam() MultipartFile file) throws IOException {
        System.out.println("访问了");
        BedResult BedResult = new BedResult();
        String name = file.getOriginalFilename();
        if (!name.endsWith(".xls") && !name.endsWith(".xlsx")) {
            System.out.println("文件不是excel类型");
        } else {
            BedResult=bedService.getDataFromExcel(file.getInputStream());//

        }

        return BedResult;
    }





}
