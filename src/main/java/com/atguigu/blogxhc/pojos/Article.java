package com.atguigu.blogxhc.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Article {
    private Integer id;
    private String title;
    private String content;
    private Integer cid;
    private Integer uid;
    private Date createTime;
    private Date updateTime;
}
