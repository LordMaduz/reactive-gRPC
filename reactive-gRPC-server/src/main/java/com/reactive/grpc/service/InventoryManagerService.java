package com.reactive.grpc.service;

import com.reactive.grpc.InventoryProto;
import com.reactive.grpc.ReactorInventoryManagerServiceGrpc;
import com.reactive.grpc.mapper.InventoryProtoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;
import reactor.core.publisher.Mono;

@GrpcService
@Slf4j
@RequiredArgsConstructor
public class InventoryManagerService extends ReactorInventoryManagerServiceGrpc.InventoryManagerServiceImplBase {

    private final InventoryProtoMapper inventoryProtoMapper;

    @Override
    public Mono<InventoryProto.Inventory> saveInventory(Mono<InventoryProto.Inventory> request) {
        return request.map(inventoryProtoMapper::fromProto).map(inventoryProtoMapper::toProto).doOnError(error -> System.err.printf("Error Occurred = %s %n", error))
                .onErrorResume(Mono::error);
    }


}
