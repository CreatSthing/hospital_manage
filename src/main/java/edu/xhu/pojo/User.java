package edu.xhu.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User  {

    private String username;
    private String password;
    private Integer rank;

}
