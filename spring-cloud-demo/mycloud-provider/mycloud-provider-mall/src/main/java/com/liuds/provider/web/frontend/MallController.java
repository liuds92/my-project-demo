package com.liuds.provider.web.frontend;

import com.liuds.provider.api.UserFeignApi;
import com.liuds.provider.model.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author: liuds
 * @date: 2019/3/7
 */
@RestController
public class MallController {
    @Autowired
    UserFeignApi userFeignApi;

    @GetMapping(value = "/mall/info/{userId}")
    public HashMap getMallInfo(@PathVariable(value = "userId") Integer userId){
        HashMap hm = new HashMap();
        UserDto userDto = userFeignApi.getUserInfo(userId);
        hm.put("obj", userDto);
        return hm;
    }
}
