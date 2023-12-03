package com.reactive.grpc.service;


import com.reactive.grpc.model.Inventory;
import reactor.core.publisher.Mono;

public interface InventoryManagerClient {

    Mono<Inventory> saveInventory() throws Exception;

    //Inventory findById() throws Exception;

}
