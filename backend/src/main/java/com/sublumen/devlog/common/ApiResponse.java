package com.sublumen.devlog.common;

import lombok.*;

@Getter
@AllArgsConstructor
public class ApiResponse<T> {
    private String message;
    private T data;

    public static <T> ApiResponse<T> of(String message, T data) {
        return new ApiResponse<T>(message, data);
    }
}
