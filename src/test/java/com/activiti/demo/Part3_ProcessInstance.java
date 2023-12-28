package com.activiti.demo;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @Author 尚智江
 * @description
 * @CreateDate 2023/12/28 16:00
 */

@SpringBootTest
public class Part3_ProcessInstance {

    // 注入运行实例类
    @Autowired
    private RuntimeService runtimeService;

    // 初始化流程实例
    @Test
    void initProcessInstance() {
        ProcessInstance processInstance = runtimeService
                // 1. 获取页面表单内容、请假时间、请假事由、String、formData（个人业务表）
                // 2. fromData 写入业务表，返回业务表主键 ID == businessKey
                // 3. 把业务数据与 Activiti7流程数据关联
                .startProcessInstanceByKey("Part1_Deployment", "bKey001");
        System.out.println("流程实例ID：" + processInstance.getProcessDefinitionId());
    }

    // 获取流程实例列表
    @Test
    void getProcessInstance() {
        List<ProcessInstance> list = runtimeService.createProcessInstanceQuery().list();
        for (ProcessInstance pi : list) {
            System.out.println("-----流程实例----");
            System.out.println("ProcessInstanceId: " + pi.getProcessInstanceId());
            System.out.println("ProcessDefinitionId(): " + pi.getProcessDefinitionId());
            System.out.println("isEnded: " + pi.isEnded());
            System.out.println("isSuspended: " + pi.isSuspended());
        }
    }

    // 暂停与激活流程实例（单个）
    @Test
    void activitieProcessInstance() {
        // 挂起流程实例
//        runtimeService.suspendProcessInstanceById("1989127a-a559-11ee-bda5-782b46d17275");
//        System.out.println("挂起流程实例结束");
        // 激活流程实例
        runtimeService.activateProcessInstanceById("1989127a-a559-11ee-bda5-782b46d17275");
        System.out.println("激活流程实例结束");
    }

    // 删除流程实例（单个）
    @Test
    void deltProcessInstance() {
        // s 删除实例id   s1 删除理由
        runtimeService.deleteProcessInstance("1989127a-a559-11ee-bda5-782b46d17275", "删除");
        // 删除流程实例
        System.out.println("删除流程实例结束");
    }
}
