package com.example.grpc;

import java.util.ArrayList;
import java.util.List;
import io.grpc.*;

public class Client {

    public static void main( String[] args ) throws Exception
    {
        // Creat channel
        final ManagedChannel channel = ManagedChannelBuilder.forTarget("localhost:8080").usePlaintext(true).build();

        // initialize stub
        TransferServiceGrpc.TransferServiceBlockingStub stub = TransferServiceGrpc.newBlockingStub(channel);

        // Format the request
        List<String> myAddress = new ArrayList<String>();
        myAddress.add("24th St");
        myAddress.add("University Park");
        myAddress.add("Del Mar");
        TransferServiceOuterClass.TransferRequest request = TransferServiceOuterClass.TransferRequest.newBuilder()
                .setName("Ryan L")
                .setCity("San Diego")
                .setZipCode(92130)
                .setSsn(1234)
                .addAllAddress(myAddress)
                .build();

        // stub call
        TransferServiceOuterClass.TransferResponse response = stub.transfer(request);

        // Show response
        System.out.println(response);

        // Shutdown channels
        channel.shutdown();
    }
}
