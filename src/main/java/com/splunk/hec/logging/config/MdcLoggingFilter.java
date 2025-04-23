package com.splunk.hec.logging.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.UUID;

@Component
public class MdcLoggingFilter extends OncePerRequestFilter {

    @Value("${spring.application.name:default}")
    private String appName;

    @Value("${spring.profiles.active:default}")
    private String environment;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        try {
            // add static values
            MDC.put("app", appName);
            MDC.put("env", environment);

            // Generates or Propagates the trace_id (useful if we're not using OpenTelemetry)
            String traceId = request.getHeader("X-Trace-Id");
            if (traceId == null || traceId.isEmpty()) {
                traceId = UUID.randomUUID().toString();
            }
            MDC.put("trace_id", traceId);

            // Keep processing the request
            filterChain.doFilter(request, response);
        } finally {
            // Clean the MDC to avoid leaks between requests
            MDC.clear();
        }
    }
}
