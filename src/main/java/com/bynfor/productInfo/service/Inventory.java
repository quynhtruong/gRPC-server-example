package com.bynfor.productInfo.service;

import com.bynfor.service.ItemList;
import com.bynfor.service.UpdateItemsResp;
import java.util.List;
import org.lognet.springboot.grpc.GRpcService;
import com.bynfor.service.InventoryServiceGrpc.InventoryServiceImplBase;
import com.bynfor.service.Item;
import io.grpc.stub.StreamObserver;

@GRpcService
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
