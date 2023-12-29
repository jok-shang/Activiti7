package com.activiti.demo;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author 尚智江
 * @description
 * @CreateDate 2023/12/29 10:39
 */
@SpringBootTest
public class Part6_UEL {

    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private TaskService taskService;

    // 启动流程实例带参数，执行执行人
    @Test
    void initProcessInstanceWithArgs() {
        // 流程变量  ${ZhiXingRen}
        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("ZhiXingRen", "悟空");
        // 流程定义
        ProcessInstance processInstance = runtimeService
                .startProcessInstanceByKey("Part6_UEL_V1", "bKey006", variables);
        System.out.println("流程实例： " + processInstance.getProcessDefinitionId());
    }

    // 完成任务带参数，指定流程变量测试
    @Test
    void completeTaskWithArgs() {
        /*
        Part6_UEL_V2
        判断八戒提交  金额
        小于等于100 悟空审核
        大于100 唐僧审核
         */
        HashMap<String, Object> map = new HashMap<>();
        map.put("pay","101");
        taskService.complete("48501bec-a609-11ee-b9e2-782b46d17275",map);
        System.out.println("完成提交");
    }

    // 启动流程实例带参数，使用实体类
    @Test
    void initProcessInstanceWithClassArgs() {
        // 创建实体类
        UEL_POJO uel_pojo = new UEL_POJO();
        uel_pojo.setZhixingren("八戒");
        // 流程变量
        HashMap<String, Object> map = new HashMap<>();
        map.put("uelpojo",uel_pojo);

        ProcessInstance processInstance = runtimeService
                .startProcessInstanceByKey("Part6_UEL_V3", "bKey006", map);
        System.out.println("流程实例ID： " + processInstance.getProcessDefinitionId());
    }

    // 任务完成环节带参数，指定多个候选人
    @Test
    void initProcessInstanceWithCandiDateArgs() {
        // UEL_V3
        HashMap<String, Object> map = new HashMap<>();
        map.put("houxuanren","悟空,唐僧");
        taskService.complete("5a9c0622-a616-11ee-a8e5-782b46d17275",map);
        System.out.println("完成提交");
    }

    // 直接指定流程变量
    void otherArgs(){
        /*
        s 流程实例id
        s1 流程变量
        o 流程变量值
         */
        runtimeService.setVariable("5a9c0622-a616-11ee-a8e5-782b46d17275",
                "pay","101");
//        runtimeService.setVariables();
//        taskService.setVariable();
//        taskService.setVariables();
    }

    // 局部变量
    @Test
    void otherLocalArgs(){
        runtimeService.setVariableLocal("5a9c0622-a616-11ee-a8e5-782b46d17275",
                "pay",
                "101");
//        runtimeService.setVariablesLocal();
//        taskService.setVariableLocal();
//        taskService.setVariablesLocal();
    }
}
