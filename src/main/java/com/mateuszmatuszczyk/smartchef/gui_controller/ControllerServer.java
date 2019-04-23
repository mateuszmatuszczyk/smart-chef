/**
 * @author Mateusz Matuszczyk
 */
package com.mateuszmatuszczyk.smartchef.gui_controller;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Logger;

import com.mateuszmatuszczyk.jmdns.JmDNSRegistrationHelper;

import com.mateuszmatuszczyk.smartchef.ControllerStatus;
import com.mateuszmatuszczyk.smartchef.GUIControllerGrpc;
//import com.mateuszmatuszczyk.smartchef.CookerStatus;
//import com.mateuszmatuszczyk.smartchef.SmartCookerGrpc;

/**
 * @author Matimek
 * Server that manages startup/shutdown of a {@code Cooker} server.
 */

public class ControllerServer {

    private static final Logger logger = Logger.getLogger(ControllerServer.class.getName());

    /* The port on which the server should run */
    private int port = 50001;
    private Server server;

    private void start() throws Exception {
        server = ServerBuilder.forPort(port)
                .addService(new ControllerImplementation())
                .build()
                .start();
    JmDNSRegistrationHelper helper = new JmDNSRegistrationHelper("SmartChef", "_GUIcontroller._udp.local.", "", port);
        
        logger.info("Server started, listening on port: " + port);
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                // Use stderr here since the logger may have been reset by its JVM shutdown hook.
                System.err.println("*** shutting down gRPC server since JVM is shutting down");
                ControllerServer.this.stop();
                System.err.println("*** server shut down");
            }
        });
    }

    private void stop() {
        if (server != null) {
            server.shutdown();
        }
    }

    /**
     * Await termination on the main thread since the grpc library uses daemon
     * threads.
     */
    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    /**
     * Main launches the server from the command line.
     */
    public static void main(String[] args) throws Exception {
        final ControllerServer controller_server = new ControllerServer();
        controller_server.start();
        controller_server.blockUntilShutdown();
    }

    private class ControllerImplementation extends GUIControllerGrpc.GUIControllerImplBase {
        
        private boolean controller_active = false;
        
        private String statusMsgOff = "Inactive";
        private String statusMsgOn = "Active";
        
        public ControllerImplementation() {
            String name = "SmartChef GUI Controller";
            String serviceType = "_GUIcontroller._udp.local.";
        }
    
        @Override
        public void switchOn(com.google.protobuf.Empty request,
            io.grpc.stub.StreamObserver<ControllerStatus> response) {
        
    
            controller_active = true;
                        
            response.onNext(ControllerStatus.newBuilder().setStatusMessage(statusMsgOn).build());
            response.onCompleted();
        }
   
        @Override
        public void switchOff(com.google.protobuf.Empty request,
            io.grpc.stub.StreamObserver<ControllerStatus> response) {
            controller_active = false; 
                        
            response.onNext(ControllerStatus.newBuilder().setStatusMessage(statusMsgOff).build());
            response.onCompleted();
        }
    }
}

