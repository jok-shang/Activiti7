package com.activiti.demo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author 尚智江
 * @description
 * @CreateDate 2023/12/29 13:19
 */

  /*
    注意不能使用驼峰命名
    必须实现序列化
     */
@Data
public class UEL_POJO implements Serializable {

    /*
    注意不能使用驼峰命名
     */
    private String zhixingren;

    private String pay;

}
