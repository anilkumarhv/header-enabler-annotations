package com.anil.enablerannotation.commonheader.filter;

import com.anil.enablerannotation.commonheader.service.TraceIdGenerator;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class TraceIdHeaderFilter extends OncePerRequestFilter {

    private final TraceIdGenerator traceIdGenerator;

    public TraceIdHeaderFilter(TraceIdGenerator traceIdGenerator) {
        this.traceIdGenerator = traceIdGenerator;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        response.setHeader("X-Trace-Id", traceIdGenerator.generate());
        filterChain.doFilter(request, response);
    }
}
