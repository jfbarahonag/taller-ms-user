package com.ms.user.dto;

import lombok.Builder;

@Builder
public record ErrorDto(
    String message
) {

}
