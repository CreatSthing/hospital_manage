package edu.xhu.service.imp;

import edu.xhu.common.BedResult;
import edu.xhu.mapper.BedMapper;
import edu.xhu.pojo.Bed;
import edu.xhu.service.BedService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BedServiceImp implements BedService {


    @Autowired
    BedMapper bedMapper;

    BedResult bedResult=new BedResult();
    Bed bed=new Bed();

    @Override
    public BedResult searchByPage(Integer page,Integer limit,Integer bed_ID,String bed_num){

        Map<String,Object> data=new HashMap<>();
        data.put("pageNow",(page-1)*limit);
        data.put("pageSize",limit);
        data.put("id",bed_ID);
        data.put("num",bed_num);
        Integer totalSize= bedMapper.Sizes(data);
        bedResult.setCount(totalSize);
        List<Bed> list= bedMapper.researchByPage(data);
        bedResult.setData(list);
        if(bedResult!=null){
            bedResult.setCode(0);
            bedResult.setMsg("查询成功");
        }else{
            bedResult.setCode(500);
            bedResult.setMsg("Oh,you failed");

        }

        return bedResult;
    }

    @Override
    public BedResult bedAdd(Bed bed) {
        Integer i=bedMapper.insert(bed);
        if(i==1){
            bedResult.setCode(200);
            bedResult.setMsg("添加成功");

        }else{
            bedResult.setCode(500);
            bedResult.setMsg("添加失败");
        }
        return bedResult;
    }

    @Override
    public BedResult bedDel(Bed bed) {
        Integer i=bedMapper.delect(bed);
        if(i==1){
            bedResult.setCode(200);
            bedResult.setMsg("删除成功");

        }else{
            bedResult.setCode(500);
            bedResult.setMsg("删除失败");
        }
        return bedResult;

    }

    @Override
    public BedResult bedUpdate(Bed bed) {
        Integer i=bedMapper.update(bed);

        if(i==1){
            bedResult.setCode(200);
            bedResult.setMsg("修改成功");

        }else{

            bedResult.setCode(500);
            bedResult.setMsg("修改失败或者数据相同无需更新");
        }
        return bedResult;
    }

    @Override
    public BedResult getDataFromExcel(InputStream inputStream) {

        Workbook wookbook = null;
        try
        {
            //2003版本的excel，用.xls结尾
            wookbook = new HSSFWorkbook(inputStream);//得到工作簿
        }
        catch (Exception ex)
        {
            //ex.printStackTrace();
            try
            {
                //2007版本的excel，用.xlsx结尾
                wookbook = new XSSFWorkbook(inputStream);//得到工作簿
            } catch (IOException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        //得到一个工作表
        Sheet sheet = wookbook.getSheetAt(0);
        //获得表头
        Row rowHead = sheet.getRow(0);
        //判断表头是否正确
        if(rowHead.getPhysicalNumberOfCells()<1 )
        {
            System.out.println("表头的数量不对!");
        }
        //获得数据的总行数
        int totalRowNum = sheet.getLastRowNum();
        int i,j=0;
        //要获得属性
        String bed_no=null ;
        String bed_roomId=null;
        String bed_judge =null;
        //获得所有数据
        for( i = 1 ; i <= totalRowNum ; i++)
        {
            //获得第i行对象
            Row row = sheet.getRow(i);
            //获得获得第i行第0列的 String类型对象
            Cell cell = row.getCell((short)0);
            bed_no=cell.getStringCellValue().toString();
            //获得一个字符串类型的数据
            cell = row.getCell((short)1);
            bed_roomId =   cell.getStringCellValue().toString();
            cell = row.getCell((short)2);
            bed_judge =  cell.getStringCellValue().toString();
            bed.setBed_no(bed_no);
            bed.setBed_roomId(bed_roomId);
            bed.setBed_judge(bed_judge);
            int get=bedMapper.insert(bed);
            if(get!=1){
                j++;
            }

        }
        if(j==totalRowNum){
            bedResult.setCode(200);
            bedResult.setMsg("所有添加成功");
        }else{
            bedResult.setCode(500);
            bedResult.setMsg("添加失败");
        }

        return bedResult;
    }


}
