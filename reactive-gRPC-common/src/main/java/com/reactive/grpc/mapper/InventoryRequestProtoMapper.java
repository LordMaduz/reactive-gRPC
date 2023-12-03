package com.reactive.grpc.mapper;

import com.reactive.grpc.InventoryRequestProto;
import com.reactive.grpc.model.InventoryRequest;
import org.springframework.stereotype.Component;

@Component
public class InventoryRequestProtoMapper implements ProtobufMapper<InventoryRequest, InventoryRequestProto.InventoryRequest>{
    @Override
    public Class<InventoryRequest> getJavaClassType() {
        return InventoryRequest.class;
    }

    @Override
    public Class<InventoryRequestProto.InventoryRequest> getProtoClassType() {
        return InventoryRequestProto.InventoryRequest.class;
    }

    @Override
    public InventoryRequestProto.InventoryRequest toProto(InventoryRequest inventoryRequest) {
        InventoryRequestProto.InventoryRequest.Builder builder = InventoryRequestProto.InventoryRequest.newBuilder();
        setIfNotNull(inventoryRequest::getId,builder::setId);
        return builder.build();
    }

    @Override
    public InventoryRequest fromProto(InventoryRequestProto.InventoryRequest proto) {
        InventoryRequest inventoryRequest = InventoryRequest.builder()
                .id(proto.getId())
                .build();
        return inventoryRequest;
    }
}
