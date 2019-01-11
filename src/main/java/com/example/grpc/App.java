package com.example.grpc;

import io.grpc.*;
/**
 * Let client know that server received info and display
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
        // Create a new server to listen on port 8080
        Server server = ServerBuilder.forPort(8080).addService(new TransferServiceImpl()).build();

        // Start the server
        server.start();

        // Server threads are running in the background.
        System.out.println("Server started!!!");

        // Keep the main thread running. Wait until server is terminated.
        server.awaitTermination();
    }
}
