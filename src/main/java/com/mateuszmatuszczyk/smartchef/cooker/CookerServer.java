package com.mateuszmatuszczyk.smartchef.cooker;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Logger;

import com.mateuszmatuszczyk.jmdns.JmDNSRegistrationHelper;
import com.mateuszmatuszczyk.smartchef.CookerStatus;
import com.mateuszmatuszczyk.smartchef.SmartCookerGrpc;

/**
 * @author Matimek
 * Server that manages startup/shutdown of a {@code Cooker} server.
 */

public class CookerServer {

    private static final Logger logger = Logger.getLogger(CookerServer.class.getName());

    /* The port on which the server should run */
    private int port = 50000;
    private Server server;

    private void start() throws Exception {
        server = ServerBuilder.forPort(port)
                .addService(new CookerImplementation())
                .build()
                .start();
    JmDNSRegistrationHelper helper = new JmDNSRegistrationHelper("SmartChef", "_cooker._udp.local.", "", port);
        
        logger.info("Server started, listening on port: " + port);
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                // Use stderr here since the logger may have been reset by its JVM shutdown hook.
                System.err.println("*** shutting down gRPC server since JVM is shutting down");
                CookerServer.this.stop();
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
    
    private class CookerImplementation extends SmartCookerGrpc.SmartCookerImplBase {
        
        private boolean cooker_active = false;
        private int cooker_temperature = 0;
        
        private String statusMsgOff = "Inactive";
        private String statusMsgOn = "Active";
        
        public CookerImplementation() {
            String name = "SmartCooker";
            String serviceType = "_cooker._udp.local.";
        }       
    
        @Override
        public void switchOn(com.google.protobuf.Empty request,
            io.grpc.stub.StreamObserver<CookerStatus> response) {
        
    
            cooker_active = true;
                        
            response.onNext(CookerStatus.newBuilder().setStatusMessage(statusMsgOn).setTemperature(cooker_temperature).build());
            response.onCompleted();
        }
   
        @Override
        public void switchOff(com.google.protobuf.Empty request,
            io.grpc.stub.StreamObserver<CookerStatus> response) {
            cooker_active = false; 
                        
            response.onNext(CookerStatus.newBuilder().setStatusMessage(statusMsgOff).setTemperature(cooker_temperature).build());
            response.onCompleted();
        }
        
        @Override
        public void cookerStatus(com.google.protobuf.Empty request,
            io.grpc.stub.StreamObserver<CookerStatus> response) 
        {
            if(cooker_active == false){           
                response.onNext(CookerStatus.newBuilder().setStatusMessage(statusMsgOff).setTemperature(cooker_temperature).build());
            }
            else
            {
                response.onNext(CookerStatus.newBuilder().setStatusMessage(statusMsgOn).setTemperature(cooker_temperature).build());
            }
            response.onCompleted();
        }
        
        @Override
        public void startHeating(com.google.protobuf.Empty request,
                io.grpc.stub.StreamObserver<CookerStatus> responseObserver) 
        {
            Timer t = new Timer();
            t.schedule(new HeatUp(responseObserver), 0, 2000);
        }
        
        class HeatUp extends TimerTask {

            StreamObserver<CookerStatus> streamObserver;

            public HeatUp(StreamObserver<CookerStatus> status) {
                streamObserver = status;
            }
            
            @Override
            public void run() {
                if (cooker_temperature < 100) {
                    cooker_temperature += 10;
                    CookerStatus cooker_status = CookerStatus.newBuilder().setTemperature(cooker_temperature).build();
                    streamObserver.onNext(cooker_status);
                } else {
                    CookerStatus cooker_status = CookerStatus.newBuilder().setStatusMessage("Heating completed! The cooker is at 100% temperature.").setTemperature(cooker_temperature).build();
                    streamObserver.onNext(cooker_status);
                    streamObserver.onCompleted();
                    this.cancel();
                }
            }
        }
        
        @Override
        public void stopHeating(com.google.protobuf.Empty request,
                io.grpc.stub.StreamObserver<CookerStatus> responseObserver) {
            Timer t = new Timer();
            t.schedule(new CoolDown(responseObserver), 0, 2000);
        }
        
        class CoolDown extends TimerTask {

            StreamObserver<CookerStatus> streamObserver;

            public CoolDown(StreamObserver<CookerStatus> status) {
                streamObserver = status;
            }
            
            @Override
            public void run() {
                if (cooker_temperature > 0) {
                    cooker_temperature -= 10;
                    CookerStatus cooker_status = CookerStatus.newBuilder().setTemperature(cooker_temperature).build();
                    streamObserver.onNext(cooker_status);
                } else {
                    CookerStatus cooker_status = CookerStatus.newBuilder().setStatusMessage("Cooldown completed! The cooker is at 0% temperature.").setTemperature(cooker_temperature).build();
                    streamObserver.onNext(cooker_status);
                    streamObserver.onCompleted();
                    this.cancel();
                }
            }
        }
    }
    
    /**
     * Main launches the server from the command line.
     */
    public static void main(String[] args) throws Exception {
        final CookerServer cooker_server = new CookerServer();
        cooker_server.start();
        cooker_server.blockUntilShutdown();
    }
}

