package com.nacos.rpc;

import com.liuds.service.feigh.PersonService;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuds
 * @date 2019-08-26 14:24
 */
@RestController
public class PersonController implements PersonService {

    @Override
    public String getPerson(String name) {
        return "欢迎您，" + name;
    }
}
