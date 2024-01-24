package com.activiti.demo;

import org.activiti.api.process.model.ProcessInstance;
import org.activiti.api.process.runtime.ProcessRuntime;
import org.activiti.api.runtime.shared.query.Page;
import org.activiti.api.runtime.shared.query.Pageable;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author 尚智江
 * @description
 * @CreateDate 2024/1/2 10:33
 */
public class Part8_ProcessRuntime {


    @Autowired
    private ProcessRuntime processRuntime;

    @Autowired
    private SecurityUtil securityUtil;

    // 获取流程实例
    @Test
    void initProcessInstance() {
        securityUtil.logInAs("八戒");
        Page<ProcessInstance> processInstancePage = processRuntime
                .processInstances(Pageable.of(0, 100));
        System.out.println("流程实例数量： " + processInstancePage.getTotalItems());
    }

    // 启动流程实例
    @Test
    void startProcessInstance() {


    }

    // 删除流程实例
    void delProcessInstance() {


    }

    // 挂起流程实例
    @Test
    void suspendProcessInstance() {


    }

    // 激活流程实例
    @Test
    void resumProcessInstance() {


    }

    // 流程实例参数
    @Test
    void getVariables() {


    }
}
