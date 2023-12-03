package com.reactive.grpc.controller;

import com.reactive.grpc.model.Inventory;
import com.reactive.grpc.service.InventoryManagerGrpcClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class GRPCController {

    private final InventoryManagerGrpcClient inventoryManagerGrpcClient;

    @GetMapping
    public Mono<Inventory> saveInventory() throws Exception {
        return inventoryManagerGrpcClient.saveInventory();
    }
}
