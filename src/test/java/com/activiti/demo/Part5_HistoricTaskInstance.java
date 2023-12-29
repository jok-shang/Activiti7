package com.activiti.demo;

import org.activiti.engine.HistoryService;
import org.activiti.engine.history.HistoricTaskInstance;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @Author 尚智江
 * @description
 * @CreateDate 2023/12/29 9:44
 */

@SpringBootTest
public class Part5_HistoricTaskInstance {

    @Autowired
    private HistoryService historyService;

    // 根据用户名查询历史记录
    @Test
    void HistoricTaskInstanceByUser() {
        List<HistoricTaskInstance> list = historyService
                .createHistoricTaskInstanceQuery()
                .orderByHistoricTaskInstanceEndTime().asc()
                .taskAssignee("悟空")
                .list();
        for (HistoricTaskInstance hi : list) {
            System.out.println("--------------");
            System.out.println("Id：" + hi.getId());
            System.out.println("ProcessInstanceId：" + hi.getProcessInstanceId());
            System.out.println("Name：" + hi.getName());
        }
    }

    // 根据流程实例ID查询历史
    @Test
    void HistoricTaskInstanceByPiID() {
        List<HistoricTaskInstance> list = historyService
                .createHistoricTaskInstanceQuery()
                .orderByHistoricTaskInstanceEndTime().asc()
                .processInstanceId("ccdb3de1-a5e8-11ee-a30d-782b46d17275")
                .list();
        for (HistoricTaskInstance hi : list) {
            System.out.println("Id：" + hi.getId());
            System.out.println("ProcessInstanceId：" + hi.getProcessInstanceId());
            System.out.println("Name：" + hi.getName());
        }
    }
}
