package edu.xhu.mapper;

import edu.xhu.pojo.Dept;

import java.util.List;
import java.util.Map;

public interface DeptMapper {
    //1.分页查询确诊病例数据封装List集合
    List<Dept> queryDeptListByPage(Map<String, Object> data);

    //2.查询总记录数
    Integer countDept();

    //3.新增确诊病例
    Integer addDept(Dept dept);

    //4.删除确诊病例
    Integer delDeptById(Integer id);

    //5.修改确诊病例
    Integer updateDeptById(Dept dept);

    //6.按照条件分页查询确诊病例数据封装List集合
    List<Dept> queryDeptListByPageAndArgs(Map<String, Object> data);

    //7.按照条件查询总记录数
    Integer countDeptByArgs(Map<String, Object> data);

    //8.查询数据，把数据导出到Excel
    List<Dept> exportDeptList();
}
