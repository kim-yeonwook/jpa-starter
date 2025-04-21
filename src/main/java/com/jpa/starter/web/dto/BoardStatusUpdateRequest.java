package com.jpa.starter.web.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

public record BoardStatusUpdateRequest(
        @NotEmpty(message = "필수값 입니다.")
        @Pattern(regexp= "ACTIVE|INACTIVE", message = "올바른 형식의 값을 입력해주세요(활성화: ACTIVE, 비활성화: INACTIVE)")
        String status
) {
}
