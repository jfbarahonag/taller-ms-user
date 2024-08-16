package com.ms.user.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;

@Builder
public record UserDto(
    @NotBlank
    @NotEmpty
    @Size(min=2)
    String name,
    
    @NotBlank
    @NotEmpty
    @Size(min=2, max=11)
    @Pattern(regexp="^[0-9]*$", message="Only numbers are allowed")
    String document,
    
    @NotBlank
    @NotEmpty
    @Size(min=2, max=3)
    @Pattern(regexp="^(TI|CC|CE|NIT)$", message="Pattern invalid in document type")
    String documentType) {

    }
