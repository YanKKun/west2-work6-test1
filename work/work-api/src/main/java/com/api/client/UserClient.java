package com.api.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("user-service")
public interface UserClient {
    /**
     * 增加总量
     * @param num 数量
     */
    @PostMapping("/user/increase")
    public void increaseTotal(@RequestParam("num") Integer num);

    /**
     * 减少总量
     * @param num 数量
     */
    @PostMapping("/user/decrease")
    public void decreaseTotal(@RequestParam("num") Integer num);
}
