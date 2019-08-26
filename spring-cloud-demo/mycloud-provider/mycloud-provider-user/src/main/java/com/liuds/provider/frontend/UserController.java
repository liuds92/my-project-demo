package com.liuds.provider.frontend;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: liuds
 * @date: 2019/3/7
 */
@RestController
@Api(description = "swaggerDemoController相关的api")
public class UserController {

    @GetMapping(value = "/user/test")
    @ApiOperation(value = "测试接口，需要校验token", notes = "测试接口，需要校验token", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParam(name = "name", value = "姓名", paramType = "query", required = true, dataType = "String")
    public String test(@RequestParam String name){
        return "my name is " + name;
    }
    @GetMapping(value = "/common/test")
    public String test1(@RequestParam String name){
        return "test is " + name;
    }
}
