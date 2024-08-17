package com.ms.user.dto;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;

@Builder
public record EmailDto(
    @NotNull
    @NotEmpty
    @Size(max = 5)
    List<String> to,
    
    @NotNull
    @Size(max = 5)
    List<String> bcc,
    
    @NotNull
    @NotEmpty
    @NotBlank
    @Size(min = 1, max = 50)
    String subject,
    
    @NotNull
    @NotEmpty
    @NotBlank
    @Size(min = 1, max = 100)
    String body
) {
}
