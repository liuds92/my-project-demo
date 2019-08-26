package com.liuds.dubbo.demo.consumer;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import com.liuds.dubbo.demo.DemoService;
import com.liuds.dubbo.demo.consumer.comp.DemoServiceComponent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author: liuds
 * @date: 2019/6/27
 */
public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConsumerConfiguration.class);
        context.start();
        DemoService service = context.getBean("demoServiceComponent", DemoServiceComponent.class);
        String hello = service.sayHello("liuds");
        System.out.println("result :" + hello);
    }

    @Configuration
    @EnableDubbo(scanBasePackages = "com.liuds.dubbo.demo.consumer.comp")
    @PropertySource("classpath:/spring/dubbo-consumer.properties")
    @ComponentScan(value = {"com.liuds.dubbo.demo.consumer.comp"})
    static class ConsumerConfiguration {

    }
}
