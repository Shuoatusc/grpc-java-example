package com.example.grpc;

import io.grpc.stub.StreamObserver;

public class TransferServiceImpl  extends TransferServiceGrpc.TransferServiceImplBase {
    @Override
    public void transfer(TransferServiceOuterClass.TransferRequest request,
                         StreamObserver<TransferServiceOuterClass.TransferResponse> responseObserver) {

        System.out.println(request);

        TransferServiceOuterClass.TransferResponse response = TransferServiceOuterClass.TransferResponse.newBuilder().setReceivedNotice("Hello, we received your info").build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();

    }
}
