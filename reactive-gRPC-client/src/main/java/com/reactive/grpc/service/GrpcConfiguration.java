package com.reactive.grpc.service;

import com.reactive.grpc.ReactorInventoryManagerServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GrpcConfiguration {
    private ManagedChannel getManagedChannel() {
        return ManagedChannelBuilder
                .forAddress("localhost", 8000)
                .usePlaintext()
                .build();
    }

    @Bean
    public ReactorInventoryManagerServiceGrpc.ReactorInventoryManagerServiceStub inventoryManagerServiceFutureStub() {
        return ReactorInventoryManagerServiceGrpc.newReactorStub(getManagedChannel());
    }
}
