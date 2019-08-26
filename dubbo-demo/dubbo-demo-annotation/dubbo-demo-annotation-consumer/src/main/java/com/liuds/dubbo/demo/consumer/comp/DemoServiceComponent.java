package com.liuds.dubbo.demo.consumer.comp;

import com.alibaba.dubbo.config.annotation.Reference;
import com.liuds.dubbo.demo.DemoService;
import org.springframework.stereotype.Component;

/**
 * @author: liuds
 * @date: 2019/6/27
 */
@Component("demoServiceComponent")
public class DemoServiceComponent implements DemoService {
    @Reference
    private DemoService demoService;

    @Override
    public String sayHello(String name) {
        return demoService.sayHello(name);
    }
}

