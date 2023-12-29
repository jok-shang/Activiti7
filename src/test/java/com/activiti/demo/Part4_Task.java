package com.activiti.demo;

import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @Author 尚智江
 * @description
 * @CreateDate 2023/12/28 17:09
 */

@SpringBootTest
public class Part4_Task {

    @Autowired
    private TaskService taskService;

    // 任务查询
    @Test
    void getTasks(){
        List<Task> list = taskService.createTaskQuery().list();
        for (Task task : list){
            System.out.println("任务id: "+task.getId());
            System.out.println("环节名称：" + task.getName());
            System.out.println("任务执行人Assignee： "+task.getAssignee());
        }
    }

    // 查询我的代办任务
    @Test
    void getTasksByAssignee(){
        List<Task> list = taskService.createTaskQuery()
                .taskAssignee("唐僧")
                .list();
        for (Task task : list){
            System.out.println("任务id："+task.getId());
            System.out.println("环节名称：" + task.getName());
            System.out.println("任务执行人Assignee： "+task.getAssignee());
            System.out.println("时间： " + task.getCreateTime());
        }
    }

    // 执行任务
    @Test
    void completeTask(){
        taskService.complete("05a56a35-a613-11ee-b6ab-782b46d17275");
        System.out.println("完成任务");
    }

    // 拾取任务/归还任务 (候选人 --- 谁先拾取谁执行)
    @Test
    void claimTask(){
        Task task = taskService.createTaskQuery()
                .taskId("ccf41d15-a5e8-11ee-a30d-782b46d17275")
                .singleResult();
        //任务拾取
//        taskService.claim("ccf41d15-a5e8-11ee-a30d-782b46d17275","八戒");
//        System.out.println("任务拾取");

        // 任务归还 （s1  为null 归还任务， s1 为用户  交办任务）
        taskService.setAssignee("ccf41d15-a5e8-11ee-a30d-782b46d17275","悟空");

    }

}
