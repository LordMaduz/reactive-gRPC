package com.reactive.grpc.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Inventory {
    private String inventoryId;
    private String name;
}
