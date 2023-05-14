package edu.xhu.comon;

import lombok.Data;

import java.io.Serializable;

@Data
public class R<T> implements Serializable {
   private Integer code;
   private String msg;
   private T data;

}
