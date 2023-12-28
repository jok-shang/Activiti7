package com.activiti.demo;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.ProcessDefinition;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @Author 尚智江
 * @description
 * @CreateDate 2023/12/28 14:41
 */
@SpringBootTest
public class Part2_ProcessDefinition {

    // 注入仓库类
    @Autowired
    private RepositoryService repositoryService;


    // 查询流程定义
    @Test
    public void getDeployment(){
        List<ProcessDefinition> list = repositoryService.createProcessDefinitionQuery()
                .list();
        for (ProcessDefinition pd : list){
            // 获取名字
            System.out.println("Name: "+pd.getName());
            // 获取key
            System.out.println("Key: "+pd.getKey());
            // 获取资源名称
            System.out.println("ResourceName: "+pd.getResourceName());
            // 获取id
            System.out.println("DeploymentId: "+pd.getDeploymentId());
            // 获取版本
            System.out.println("Version: "+pd.getVersion());
        }
    }

    // 删除流程定义
    @Test
    public void delDefinition(){
        String pdID = "a9b39f24-a54d-11ee-bcfc-782b46d17275";
        // 参数为true的话，删除所有流程实例，历史（删除所有历史记录）/ false 留痕
        repositoryService.deleteDeployment(pdID,true);
        System.out.println("删除流程定义成功");
    }



}
