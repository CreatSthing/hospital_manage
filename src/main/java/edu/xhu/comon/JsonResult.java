package edu.xhu.comon;

import lombok.Data;

/*
封装了后端给前端响应回来数据（包括分页需要的）
msg code data count
实体类-泛型类
封装：属性私有化(private) 行为公开化(get和set方法)
 */
@Data
public class JsonResult<T> {
    private Integer code;//状态码 200成功 400 500失败   0 数据表格成功显示数据-layui规定状态
    private String msg;//成功 失败
    private Integer count;//总记录数
    private T data;//数据 entity List Map等
}
