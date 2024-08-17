package com.ms.user.external.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

import com.ms.user.dto.EmailDto;
import com.ms.user.dto.EmailStatusDto;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@FeignClient(name="MS-NOTIFICATIONS/v1/email")
public interface NotificationServiceFeign {
    @PostMapping("/send")
    ResponseEntity<EmailStatusDto> send(@RequestBody EmailDto emailDto);
}
