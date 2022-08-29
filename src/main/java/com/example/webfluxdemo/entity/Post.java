package com.example.webfluxdemo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xiaobox
 * @since 2022/8/28 10:39 AM
 */
@NoArgsConstructor
@Data
public class Post {


    private Integer userId;
    private Integer id;
    private String title;
    private String body;


}
