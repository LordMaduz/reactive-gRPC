package com.reactive.grpc.mapper;

import com.reactive.grpc.InventoryProto;
import com.reactive.grpc.model.Inventory;
import org.springframework.stereotype.Component;

@Component
public class InventoryProtoMapper implements ProtobufMapper<Inventory, InventoryProto.Inventory>{
    @Override
    public Class<Inventory> getJavaClassType() {
        return Inventory.class;
    }

    @Override
    public Class<InventoryProto.Inventory> getProtoClassType() {
        return InventoryProto.Inventory.class;
    }

    @Override
    public InventoryProto.Inventory toProto(Inventory inventory) {
        InventoryProto.Inventory.Builder builder = InventoryProto.Inventory.newBuilder();
        setIfNotNull(inventory::getInventoryId,builder::setInventoryId);
        setIfNotNull(inventory::getName,builder::setName);
        return builder.build();
    }

    @Override
    public Inventory fromProto(InventoryProto.Inventory proto) {
        Inventory inventory = Inventory.builder()
                .inventoryId(proto.getInventoryId())
                .name(proto.getName())
                .build();
        return inventory;
    }
}
