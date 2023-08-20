package com.atguigu.blogxhc.vos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
@Data
@AllArgsConstructor
public class UserVo implements Serializable {
    private Integer uid;
    private String name;
}
