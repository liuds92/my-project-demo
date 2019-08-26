package com.liuds.provider.api;

import com.liuds.provider.api.hystric.UserFeignHystric;
import com.liuds.provider.model.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author: liuds
 * @date: 2019/3/7
 */
@FeignClient(value = "mycloud-provider-user", fallback = UserFeignHystric.class)
public interface UserFeignApi {

    @GetMapping(value = "/api/user/{userId}")
    UserDto getUserInfo(@PathVariable("userId") Integer userId);
}
