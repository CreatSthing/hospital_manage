package edu.xhu.common;


import lombok.Data;
/*
* 封装了后端给前端响应回来数据
* msg code data
* 实体类-泛型类
* 封装：属性私有化（private） 行为公开化（get和set方法）
* */
@Data
public class R<T> {
    private Integer code;//状态码200成功 400 500失败 0数据表格成功显示数据-layui规定状态
    private String msg;//成功 失败
    private T data;//数据entity List Map等


}
