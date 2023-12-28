package com.activiti.demo;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.Model;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.InputStream;
import java.util.List;
import java.util.zip.ZipInputStream;

/**
 * @Author 尚智江
 * @description
 * @CreateDate 2023/12/28 13:51
 */
@SpringBootTest
class Part1_Deployment {


    // 注入仓库类
    @Autowired
    private RepositoryService repositoryService;


    // 通过bpmn部署流程
    @Test
    void initDeploymentBPMN() {
        String filename = "BPMN/Part1_Deployment.bpmn20.png";
        Deployment deployment = repositoryService.createDeployment()
                .addClasspathResource(filename)
//                .addClasspathResource("BPMN/Part1_Deployment.bpmn20.xml")
                .name("流程部署测试V2-BPMN")
                .deploy();
        System.out.println(deployment.getName());
    }

    // 通过zip部署流程
    @Test
    void initDeploymentZIP() {
        String fileName = "BPMN/deployment.zip";
        InputStream fileInputStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream(fileName);
        assert fileInputStream != null;
        ZipInputStream zip = new ZipInputStream(fileInputStream);
        Deployment deployment = repositoryService.createDeployment()
                .addZipInputStream(zip)
                .name("流程部署zip")
                .deploy();
        System.out.println(deployment.getName());
    }

    // 查询流程部署
    @Test
    void getDeployment() {
        List<Deployment> list = repositoryService.createDeploymentQuery().list();
        for (Deployment dep : list) {
            System.out.println("name: " + dep.getName());
            System.out.println("id: " + dep.getId());
            System.out.println("DeploymentTime: " + dep.getDeploymentTime());
            System.out.println("Key: " + dep.getKey());
        }
    }
}
