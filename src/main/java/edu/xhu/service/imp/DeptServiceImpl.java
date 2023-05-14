package edu.xhu.service.imp;

import edu.xhu.common.JsonResult;
import edu.xhu.common.R;
import edu.xhu.mapper.DeptMapper;
import edu.xhu.pojo.Dept;
import edu.xhu.service.DeptService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;
    @Override
    public JsonResult queryDeptListByPage(Integer page, Integer limit) {
        JsonResult jsonResult = new JsonResult();
        //调用mapper层
        //1.查询总记录数
        Integer totalSize = deptMapper.countDept();
        jsonResult.setCount(totalSize);
        //2.分页查询确诊病例数据
        Map<String,Object> data = new HashMap<>();
        data.put("pageNow",(page-1)*limit);//每页起始的索引
        data.put("pageSize",limit);
        List<Dept> list = deptMapper.queryDeptListByPage(data);
        jsonResult.setData(list);
        if(jsonResult!=null){
            //查询成功
            //layui规定：数据表格要想成功显示数据，状态码code一定是0
            jsonResult.setCode(0);
            jsonResult.setMsg("查询成功");
        }else{
            //查询失败
            jsonResult.setCode(500);
            jsonResult.setMsg("系统开小差，请联系管理员");
        }
        return jsonResult;
    }

    @Override
    public JsonResult searchDept(Integer page, Integer limit, String dept_no, String dept_name) {
        JsonResult jsonResult = new JsonResult();
        try {
            //调用mapper层
            //1.按条件查询总记录数
            Map<String, Object> map = new HashMap<>();
            map.put("dept_no", dept_no);
            map.put("dept_name", dept_name);
            Integer totalSize = deptMapper.countDeptByArgs(map);
            jsonResult.setCount(totalSize);
            //2.按条件分页查询确诊病例数据
            Map<String, Object> data = new HashMap<>();
            data.put("pageNow", (page - 1) * limit);
            data.put("pageSize", limit);
            data.put("dept_no", dept_no);
            data.put("dept_name", dept_name);
            List<Dept> list = deptMapper.queryDeptListByPageAndArgs(data);
            jsonResult.setData(list);
            if (jsonResult != null) {
                jsonResult.setCode(0);//Layui数据表格规定，查询成功code必须是0
                jsonResult.setMsg("查询成功");
            }
        }catch (Exception e){
            e.printStackTrace();
            jsonResult.setCode(500);
            jsonResult.setMsg("系统开小差，请联系管理员");
        }
        return jsonResult;
    }

    @Override
    public R addDept(Dept dept) {
        R r = new R();
        int result = deptMapper.addDept(dept);
        if(result>0){
            r.setCode(200);
            r.setMsg("添加 确诊病例成功");
        }else{
            r.setCode(500);
            r.setMsg("系统开小差，请联系管理员");
        }
        return r;
    }

    @Override
    public R delDeptById(Integer id) {
        R r = new R();
        int result = deptMapper.delDeptById(id);
        if(result>0){
            r.setCode(200);
            r.setMsg("删除成功");
        }else{
            r.setCode(500);
            r.setMsg("系统开小差，请联系管理员");
        }
        return r;
    }

    @Override
    public R updateDeptById(Dept dept) {
        R r = new R();
        int result = deptMapper.updateDeptById(dept);
        if(result>0){
            r.setCode(200);
            r.setMsg("修改成功");
        }else{
            r.setCode(500);
            r.setMsg("系统开小差，请联系管理员");
        }
        return r;
    }

    @Override
    public R exportDeptList() {
        R r = new R();
        try {
            //调用mapper把数据库表中数据查询出来封装到List
            List<Dept> list = deptMapper.exportDeptList();
            if(list!=null&&list.size()>0){
                //把数据导出到Excel表格中
                //1.创建工作簿Workbook实现类对象-HSSF(2003) XSSF(2007)
                Workbook workbook = new HSSFWorkbook();//2003 .xls结尾
                //2.创建工作表sheet
                Sheet sheet = workbook.createSheet("部门信息表");
                //3.创建表头，向第一行塞表头信息
                Row row = sheet.createRow(0);
                row.createCell(0).setCellValue("ID号");
                row.createCell(1).setCellValue("部门代号");
                row.createCell(2).setCellValue("部门名称");
                row.createCell(3).setCellValue("部门主任代号");
                row.createCell(4).setCellValue("部门副主任代号");
                //4.把从数据库取出的数据塞入的表格的主体部分
                Integer rowNum = 1;
                for (Dept dept : list) {//增强for循环
                    Row listRow = sheet.createRow(rowNum);
                    listRow.createCell(0).setCellValue(dept.getDept_id());
                    listRow.createCell(1).setCellValue(dept.getDept_no());
                    listRow.createCell(2).setCellValue(dept.getDept_name());
                    listRow.createCell(3).setCellValue(dept.getDept_manager());
                    listRow.createCell(4).setCellValue(dept.getDept_viceManager());
                    rowNum++;
                }
                //5.使用IO流把数据写入到Excel表格中
                File file = new File("D:\\Dept.xls");
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    workbook.write(fileOutputStream);//写入
                    fileOutputStream.flush();//刷新
                    fileOutputStream.close();//关闭
                    workbook.close();//关闭
                } catch (IOException e) {
                    e.printStackTrace();
                }
                r.setCode(200);
                r.setMsg("导出成功");
            }else{
                r.setCode(501);
                r.setMsg("查询数据为空,导出失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            r.setCode(500);
            r.setMsg("导出失败");
        }

        return r;
    }

    @Override
    public R importDept() {
        R r = new R();
        //1.找到导入文件
        File file = new File("D:\\Dept1.xls");
        //2.创建输入流
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            //3.获取WorkBook
            Workbook workbook = new HSSFWorkbook(fis);

            //4.获取sheet
            Sheet sheet = workbook.getSheetAt(0);
            //5.获取总行数
            int rows = sheet.getLastRowNum();
            System.out.println(rows);
            //创建总容器
            List<List<String>> excelListData = new ArrayList<>();
            Dept dept = new Dept();
            //遍历
            for(int r1=1;r1<=rows;r1++){
                //获取每一行对象
                Row row = sheet.getRow(r1);
                //创建一个行容器
                List<String> rowsData = new ArrayList<>();
                //获取单元格总数
                short columns = row.getLastCellNum();
                //遍历列-从0
                for(int c=0;c<columns;c++){
                    //获取每一行的单元格Cell
                    Cell cell = row.getCell(c);
                    //获取格子里面数据类型CellType
                    CellType cellType = cell.getCellType();
                    //每个格子的初始值
                    String value = "";
                    //类型转换:因为数据类型是不用的，获取的方式也是不一样的
                    switch (cellType){
                        case STRING: //字符串型
                            value = cell.getStringCellValue();//String
                            break;
                        case NUMERIC: //数值型
                            value = new DecimalFormat("0").format(cell.getNumericCellValue());
                            break;
                        case FORMULA: //公式型
                            value = cell.getCellFormula();
                            break;
                        case BLANK: //空值
                            value = "";
                            break;
                        case BOOLEAN: //布尔型
                            value = Boolean.valueOf(cell.getBooleanCellValue()).toString();
                            break;
                        case ERROR: //错误
                            value = "error";
                            break;
                        default: //其他
                            value = "未知";
                            break;
                    }
                    rowsData.add(value);
                }
                Integer result = null;
                if(rowsData.size()>0){
                    dept.setDept_id(Integer.valueOf(rowsData.get(0)));
                    dept.setDept_no(rowsData.get(1));
                    dept.setDept_name(rowsData.get(2));
                    dept.setDept_manager(rowsData.get(3));
                    dept.setDept_viceManager(rowsData.get(4));
                    result = deptMapper.addDept(dept);
                    System.out.println(result+"条数");
                }
                if(result>0){
                    r.setCode(200);
                    r.setMsg("导入成功");
                }else {
                    r.setCode(500);
                    r.setMsg("导入失败");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return r;
    }
}
