package com.liuds.service.feigh;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author liuds
 * @date 2019-08-26 14:23
 */
@FeignClient(value = "nacos-provider")
public interface PersonService {

    @GetMapping(value = "/service/person/{name}")
    String getPerson(@PathVariable("name") String name);
}
