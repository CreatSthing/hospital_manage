package edu.xhu.common;

import lombok.Data;

@Data
public class BedResult<T> {

    private Integer code;//状态码200成功 400 500失败 0数据表格成功显示数据-layui规定状态
    private String msg;//成功 失败
    private Integer count;
    private T data;//数据entity List Map等

}
