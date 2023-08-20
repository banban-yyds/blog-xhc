package com.atguigu.blogxhc.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    private Integer cid;
    private String cname;
    private Date createTime;
    private Date updateTime;
}
