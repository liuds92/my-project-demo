package com.nacos.controller;

import com.liuds.service.feigh.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author liuds
 * @date 2019-08-26 14:33
 */
@RestController
public class PersonController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/api/person/{name}", method = RequestMethod.GET)
    public String person(@PathVariable String name) {
        return restTemplate.getForObject("http://nacos-provider/service/person/" + name, String.class);
    }

    @RequestMapping(value = "/api/person2/{name}", method = RequestMethod.GET)
    public String person2(@PathVariable String name) {
        return personService.getPerson(name);
    }
}
