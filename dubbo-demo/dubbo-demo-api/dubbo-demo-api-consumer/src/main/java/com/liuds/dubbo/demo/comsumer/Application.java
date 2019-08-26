package com.liuds.dubbo.demo.comsumer;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.liuds.dubbo.demo.DemoService;
import com.liuds.dubbo.demo.HelloException;

/**
 * @author: liuds
 * @date: 2019/6/27
 */
public class Application {
    public static void main(String[] args) {
        ReferenceConfig<DemoService> reference = new ReferenceConfig<>();
        reference.setApplication(new ApplicationConfig("dubbo-demo-api-consumer"));
        reference.setRegistry(new RegistryConfig("zookeeper://127.0.0.1:2181"));
        reference.setInterface(DemoService.class);
        DemoService server = reference.get();
        try{
            String message = server.sayHello("liuds");
            System.out.println(message);
        }catch (HelloException e){
            System.out.println("这里捕捉到HelloException异常");
        }
    }
}
