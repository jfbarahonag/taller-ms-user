package com.ms.user.dto;

import lombok.Builder;

@Builder
public record UserDto (String name, String document, String documentType) {  
}
