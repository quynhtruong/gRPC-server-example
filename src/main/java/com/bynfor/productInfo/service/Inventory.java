package com.bynfor.productInfo.service;

import com.bynfor.service.ItemList;
import com.bynfor.service.UpdateItemsResp;
import java.util.List;
import net.devh.boot.grpc.server.service.GrpcService;
import com.bynfor.service.InventoryServiceGrpc.InventoryServiceImplBase;
import com.bynfor.service.Item;
import io.grpc.stub.StreamObserver;

@GrpcService
public class Inventory extends InventoryServiceImplBase {

  @Override
  public void updateItems(ItemList request, StreamObserver<UpdateItemsResp> responseObserver) {
    List<Item> items = request.getItemList();

    for (Item item : items) {
      System.out.println(item.getCode());
    }

    responseObserver.onNext(UpdateItemsResp.newBuilder().setCode("success").build());
    responseObserver.onCompleted();
  }
}
