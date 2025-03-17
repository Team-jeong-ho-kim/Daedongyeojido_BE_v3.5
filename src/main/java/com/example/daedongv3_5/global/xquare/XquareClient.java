package com.example.daedongv3_5.global.xquare;

import com.example.daedongv3_5.domain.auth.presentation.dto.request.LoginRequest;
import com.example.daedongv3_5.global.xquare.dto.XquareUserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "xquare-client", url = "${key.login-api-url}", configuration = XquareRetryConfiguartion.class)
public interface XquareClient {
    @PostMapping("/user-data")
    XquareUserResponse xquareUser(@RequestBody LoginRequest request);

    @PatchMapping("/modify-profile")
    void modifyProfile(@RequestParam("account_id") String account_id, @RequestParam("profile_img_url") String profileImgUrl);
}

