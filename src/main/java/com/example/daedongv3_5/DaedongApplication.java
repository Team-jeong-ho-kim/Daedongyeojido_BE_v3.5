package com.example.daedongv3_5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;


@SpringBootApplication
@EnableFeignClients
@ConfigurationPropertiesScan
@ImportAutoConfiguration({FeignAutoConfiguration.class})
public class DaedongApplication {

    public static void main(String[] args) {
        SpringApplication.run(DaedongApplication.class, args);
    }

}
