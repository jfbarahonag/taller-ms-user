package com.ms.user.dto;

import lombok.Builder;

@Builder
public record EmailStatusDto (
    boolean success,
    String details
) {
}
