package com.anil.enablerannotation.commonheader.service;

import java.util.UUID;

public class UUIDTraceIdGenerator implements TraceIdGenerator {
    @Override
    public String generate() {
        return UUID.randomUUID().toString();
    }
}
