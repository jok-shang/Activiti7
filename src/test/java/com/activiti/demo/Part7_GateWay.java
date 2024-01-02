package com.activiti.demo;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;

/**
 * @Author 尚智江
 * @description
 * @CreateDate 2023/12/29 16:03
 */
@SpringBootTest
public class Part7_GateWay {

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @Test
    void initProcessInstance() {
        // 流程实例创建
        ProcessInstance processInstance = runtimeService
                .startProcessInstanceByKey("Part7_Exclusive");
        System.out.println("流程实例ID：" + processInstance.getProcessDefinitionId());
    }

    // 完成任务
    @Test
    void completeTask() {
        // 沙僧 e8b1e417-a90f-11ee-853c-782b46d17275
        // 悟空 e8b1e419-a90f-11ee-853c-782b46d17275
        // 增加流程变量
        HashMap<String, Object> map = new HashMap<>();
        map.put("day",300);
//        taskService.complete("e8b1e417-a90f-11ee-853c-782b46d17275");
        taskService.complete("e8b1e419-a90f-11ee-853c-782b46d17275");
        System.out.println("完成任务");
    }
}
