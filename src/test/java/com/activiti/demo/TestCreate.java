package com.activiti.demo;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author 尚智江
 * @description
 * @CreateDate 2023/12/28 11:01
 */
@SpringBootTest
public class TestCreate {

    /*
    使用 activiti提供的默认方式来创建mysql表
     */
    @Test
    public void createtdb(){
        // 需要使用activiti提供的工具类 ProcessEngine,使用方法getDefaultProcessEngine
        // getDefaultProcessEngine会默认从resource下读取名字为 activiti.cfg.xml的文件
        // 创建ProcessEngine的时候，就会创建mysql的表
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
    }
}
