package com.mateuszmatuszczyk.smartchef.smart_pot;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Logger;

import com.mateuszmatuszczyk.jmdns.JmDNSRegistrationHelper;
import com.mateuszmatuszczyk.smartchef.PotStatus;
import com.mateuszmatuszczyk.smartchef.SmartPotGrpc;

/**
 * @author Matimek
 * Server that manages startup/shutdown of a {@code Cooker} server.
 */

public class PotServer {

    private static final Logger logger = Logger.getLogger(PotServer.class.getName());

    /* The port on which the server should run */
    private int port = 50002;
    private Server server;

    private void start() throws Exception {
        server = ServerBuilder.forPort(port)
                .addService(new SmartPotImplementation())
                .build()
                .start();
    JmDNSRegistrationHelper helper = new JmDNSRegistrationHelper("SmartChef", "_pot._udp.local.", "", port);
        
        logger.info("Server started, listening on port: " + port);
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                // Use stderr here since the logger may have been reset by its JVM shutdown hook.
                System.err.println("*** shutting down gRPC server since JVM is shutting down");
                PotServer.this.stop();
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
    
    private class SmartPotImplementation extends SmartPotGrpc.SmartPotImplBase {
        
        private boolean potActive;
        private boolean lidOn;
        private boolean saltedWater;
        private int potTemperature;
        private int waterLevel;
        private double currentWaterVolume;
        private String statusMsg;
        

        public SmartPotImplementation() {
            
            this.potTemperature = 0;
            this.lidOn = false;
//            water level in %
            this.waterLevel = 0;
//            water level in L(itres)
            this.currentWaterVolume = 0.0;
            this.potActive = false;
            this.saltedWater = false;
            this.statusMsg = "";
            String name = "SmartPot";
            String serviceType = "_pot._udp.local.";
        }       
 
        @Override
        public void switchOn(com.google.protobuf.Empty request,
            io.grpc.stub.StreamObserver<PotStatus> response) {
            potActive = true;
            
            response.onNext(PotStatus.newBuilder()
                    .setStatusOnOff(potActive)
                    .setTemperature(potTemperature)
                    .setWaterLevel(waterLevel)
                    .setLidOn(lidOn)
                    .setSaltedWater(saltedWater)
                    .build());
            response.onCompleted();
        }
   
        @Override
        public void switchOff(com.google.protobuf.Empty request,
            io.grpc.stub.StreamObserver<PotStatus> response) {
            potActive = false; 
                        
            response.onNext(PotStatus.newBuilder()
                    .setStatusOnOff(potActive)
                    .build());
            response.onCompleted();           
        }

        
        @Override
        public void potStatus(com.google.protobuf.Empty request,
            io.grpc.stub.StreamObserver<PotStatus> response) 
        {
            PotStatus samplePotStatus = PotStatus.newBuilder()
                    .setTemperature(potTemperature)
                    .setWaterLevel(waterLevel)
                    .setLidOn(lidOn)
                    .setStatusOnOff(potActive)
                    .setStatusMsg(statusMsg)
                    .setSaltedWater(saltedWater)
                    .build();
            response.onNext(samplePotStatus);
            response.onCompleted();
        }
        
//        @Override
//        public void addWater(WaterRequest request,
//                io.grpc.stub.StreamObserver<PotStatus> response) 
//        {   
//            double waterToAdd = request.getVolume();
//            System.out.println("Adding "+waterToAdd+ "L of water to the pot...");
//            currentWaterVolume =+ waterToAdd;
//            waterLevel = 100;
//            PotStatus potStatus = PotStatus.newBuilder().setWaterLevel(waterLevel).build();        
//            response.onNext(potStatus);
//            response.onCompleted();
//        }
        
        @Override
        public void addWater(com.google.protobuf.Empty request,
                io.grpc.stub.StreamObserver<PotStatus> responseObserver) 
        {
            Timer t = new Timer();
            t.schedule(new AddWater(responseObserver), 0, 2000);
        }
        
        class AddWater extends TimerTask {

            StreamObserver<PotStatus> streamObserver;

            public AddWater(StreamObserver<PotStatus> status) {
                streamObserver = status;
            }
            
            @Override
            public void run() {
                if (waterLevel < 100) {
                    waterLevel += 10;
                    PotStatus potStatus = PotStatus.newBuilder().setWaterLevel(waterLevel).build();
                    streamObserver.onNext(potStatus);
                } else {
                    PotStatus potStatus = PotStatus.newBuilder().setStatusMsg("Adding water completed!").setWaterLevel(waterLevel).build();
                    streamObserver.onNext(potStatus);
                    streamObserver.onCompleted();
                    this.cancel();
                }
            }
        }
        
        @Override
        public void coverWithLid(com.google.protobuf.Empty request,
                io.grpc.stub.StreamObserver<PotStatus> response) 
        {   
            if (lidOn){
                lidOn = false;
            }
            else{
                lidOn = true;
            }
            PotStatus potStatus = PotStatus.newBuilder().setLidOn(lidOn).build();        
            response.onNext(potStatus);
            response.onCompleted();
        }
        
        
        
//        @Override
//        public void stopHeating(com.google.protobuf.Empty request,
//                io.grpc.stub.StreamObserver<CookerStatus> responseObserver) {
//            Timer t = new Timer();
//            t.schedule(new CoolDown(responseObserver), 0, 2000);
//        }
//        
//        class CoolDown extends TimerTask {
//
//            StreamObserver<CookerStatus> streamObserver;
//
//            public CoolDown(StreamObserver<CookerStatus> status) {
//                streamObserver = status;
//            }
//            
//            @Override
//            public void run() {
//                if (cooker_temperature > 0) {
//                    cooker_temperature -= 10;
//                    CookerStatus cooker_status = CookerStatus.newBuilder().setTemperature(cooker_temperature).build();
//                    streamObserver.onNext(cooker_status);
//                } else {
//                    CookerStatus cooker_status = CookerStatus.newBuilder().setStatusMessage("Cooldown completed! The cooker is at 0% temperature.").setTemperature(cooker_temperature).build();
//                    streamObserver.onNext(cooker_status);
//                    streamObserver.onCompleted();
//                    this.cancel();
//                }
//            }
//        }
    }
    /**
     * Main launches the server from the command line.
     */
    public static void main(String[] args) throws Exception {
        final PotServer potServer = new PotServer();
        potServer.start();
        potServer.blockUntilShutdown();
    }
}

