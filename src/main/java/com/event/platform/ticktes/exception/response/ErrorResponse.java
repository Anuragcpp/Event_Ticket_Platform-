package com.event.platform.ticktes.exception.response;

public record ErrorResponse(
        String status,
        int errorcode,
        String message
) {
}
