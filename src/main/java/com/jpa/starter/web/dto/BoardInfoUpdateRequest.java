package com.jpa.starter.web.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record BoardInfoUpdateRequest(
        @NotEmpty(message = "필수값 입니다.") @Size(max = 20, message = "최대 크기를 넘어선 크기입니다.")
        String name,
        @NotEmpty(message = "필수값 입니다.") @Size(max = 200, message = "최대 크기를 넘어선 크기입니다.")
        String description,
        @NotEmpty(message = "필수값 입니다.") @Size(max = 10, message = "최대 크기를 넘어선 크기입니다.")
        String categoryCode
) {
}
