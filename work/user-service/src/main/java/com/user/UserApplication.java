package com.user;


import com.api.config.DefaultFeignConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableFeignClients(basePackages = "com.api.client",defaultConfiguration = DefaultFeignConfig.class)
@MapperScan("com.user.mapper")
@SpringBootApplication(scanBasePackages = {"com.user","com.yk"})
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }


    @Bean
    public RestTemplate restTemplate(){
        return  new RestTemplate();
    }


}