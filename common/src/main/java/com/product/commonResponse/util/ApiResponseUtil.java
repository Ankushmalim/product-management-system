package com.product.commonResponse.util;

import com.product.commonResponse.dto.ApiResponse;

import java.time.LocalDateTime;

public class ApiResponseUtil {
    public static <T> ApiResponse<T> success(String message, T data) {

        return ApiResponse.<T>builder()
                .success(true)
                .message(message)
                .data(data)
                .timestamp(LocalDateTime.now())
                .build();
    }
}
