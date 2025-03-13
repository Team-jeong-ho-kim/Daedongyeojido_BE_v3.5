package com.example.daedongv3_5.global.xquare;

import com.example.daedongv3_5.domain.auth.presentation.dto.request.LoginRequest;
import com.example.daedongv3_5.global.xquare.dto.XquareUserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "xquare-client", url = "https://prod-server.xquare.app/dsm-login", configuration = XquareRetryConfiguartion.class)
public interface XquareClient {
    @PostMapping("/user-data")
    XquareUserResponse xquareUser(@RequestBody LoginRequest request);
}
