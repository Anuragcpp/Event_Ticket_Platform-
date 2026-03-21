package com.event.platform.ticktes.security.authenticationExcrption;


import com.event.platform.ticktes.util.model.ApiResponse;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;

@Component
public class CustomeAccessDeniedHandler implements AccessDeniedHandler {
    private ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public void handle(
            HttpServletRequest request,
            HttpServletResponse response,
            AccessDeniedException accessDeniedException
    ) throws IOException, ServletException {
        response.setContentType("Application/json");
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        ApiResponse<Void> error = new ApiResponse<>(
                HttpStatus.FORBIDDEN.value(),
                "You do not have permission to access this resource",
                null
        );
        response.getWriter().write(objectMapper.writeValueAsString(error));
        return;
    }
}
