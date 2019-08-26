package com.liuds.provider.api.hystric;

import com.liuds.provider.api.UserFeignApi;
import com.liuds.provider.model.dto.UserDto;
import org.springframework.stereotype.Component;

/**
 * @author: liuds
 * @date: 2019/3/7
 */
@Component
public class UserFeignHystric implements UserFeignApi{
    @Override
    public UserDto getUserInfo(Integer userId) {
        return null;
    }
}
