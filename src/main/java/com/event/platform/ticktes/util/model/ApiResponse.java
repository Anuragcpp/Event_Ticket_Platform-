package com.event.platform.ticktes.util.model;

public record ApiResponse <T>(
        int status,
        String message ,
        T data
) {
}
