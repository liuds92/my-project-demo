package com.liuds.provider.api;

import hystric.MallFeignHystric;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author: liuds
 * @date: 2019/3/7
 */
@FeignClient(value = "mycloud-provider-mall", fallback = MallFeignHystric.class)
public interface MallFeignApi {
}
