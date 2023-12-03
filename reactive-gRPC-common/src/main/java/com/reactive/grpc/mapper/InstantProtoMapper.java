package com.reactive.grpc.mapper;

import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class InstantProtoMapper {

    public String toProto(Instant e) {
        return e.toString();
    }

    public Instant fromProto(String proto) {
        return proto.trim().isEmpty() ? null : Instant.parse(proto);
    }
}
