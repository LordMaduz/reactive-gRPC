package com.reactive.grpc.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class InventoryRequest {
    protected String id;
}
