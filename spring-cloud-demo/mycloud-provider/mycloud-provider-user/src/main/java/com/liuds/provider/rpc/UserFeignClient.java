package com.liuds.provider.rpc;

import com.liuds.provider.api.UserFeignApi;
import com.liuds.provider.model.dto.UserDto;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: liuds
 * @date: 2019/3/7
 */
@RestController
@RefreshScope
public class UserFeignClient implements UserFeignApi {
    @Override
    public UserDto getUserInfo(Integer userId) {
        UserDto userDto = new UserDto();
        userDto.setUserId(userId);
        userDto.setName("liuds");
        userDto.setSex("男");
        return userDto;
    }
}
