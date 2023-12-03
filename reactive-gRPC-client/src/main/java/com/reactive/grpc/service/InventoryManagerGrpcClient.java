package com.reactive.grpc.service;


import com.reactive.grpc.InventoryProto;
import com.reactive.grpc.ReactorInventoryManagerServiceGrpc;
import com.reactive.grpc.mapper.InventoryProtoMapper;
import com.reactive.grpc.model.Inventory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class InventoryManagerGrpcClient implements InventoryManagerClient {


    private final ReactorInventoryManagerServiceGrpc.ReactorInventoryManagerServiceStub reactorInventoryManagerServiceStub;
    private final InventoryProtoMapper inventoryProtoMapper;

    @Override
    public Mono<Inventory> saveInventory() throws Exception {
        Inventory inventory = Inventory.builder().inventoryId(UUID.randomUUID().toString()).name("NEAL").build();
        Mono<InventoryProto.Inventory> protoMono = reactorInventoryManagerServiceStub.saveInventory(Mono.just(inventoryProtoMapper.toProto(inventory)));

        return protoMono.map(inventoryProtoMapper::fromProto);
    }

}
