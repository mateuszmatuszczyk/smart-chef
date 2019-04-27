/**
 * @author Mateusz Matuszczyk
 */
package com.mateuszmatuszczyk.smartchef.gui_controller;

import com.mateuszmatuszczyk.smartchef.SmartCookerGrpc;
import com.mateuszmatuszczyk.smartchef.GUIControllerGrpc;
import com.mateuszmatuszczyk.smartchef.CookerStatus;
import com.mateuszmatuszczyk.smartchef.ControllerStatus;
import com.mateuszmatuszczyk.jmdns.jmDNSServiceTracker;
import com.mateuszmatuszczyk.jmdns.ServiceDescription;
import com.mateuszmatuszczyk.jmdns.ServiceObserver;

import com.google.protobuf.Empty;
import com.mateuszmatuszczyk.smartchef.cooker.CookerClient;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import javax.swing.JPanel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControllerClient implements ServiceObserver {
    

    protected ControllerClientGUI controller_gui;

    protected ServiceDescription current;
    private final String serviceType;
    private final String name;
    private static final Logger logger = Logger.getLogger(ControllerClient.class.getName());

    private ManagedChannel channel;
    private GUIControllerGrpc.GUIControllerBlockingStub blockingStub;
    private SmartCookerGrpc.SmartCookerBlockingStub cookerBlockingStub;
    
    /**
     * Constructor.
     */
    public ControllerClient() {
        serviceType = "_GUIcontroller._udp.local.";
        name = "GUI Controller";
        jmDNSServiceTracker clientManager = jmDNSServiceTracker.getInstance();
        clientManager.register(this);
        java.awt.EventQueue.invokeLater(new Runnable() {
             public void run() {
                controller_gui = new ControllerClientGUI(ControllerClient.this);
                controller_gui.setVisible(true);
             }
         });
        serviceAdded(new ServiceDescription("localhost", 50001));
        serviceAdded(new ServiceDescription("localhost", 50000));
    }

//    com.mateuszmatuszczyk.smartchef.cooker.CookerClient ck;
    CookerClient ck = new CookerClient();
    
    
    
    String getServiceType() {
        return serviceType;
    }

    void disable() {
        // no services exist for this client type
    }

    public List<String> serviceInterests() {
        List<String> interests = new ArrayList<String>();
        interests.add(serviceType);
        return interests;
    }

    public void serviceAdded(ServiceDescription service) {
        System.out.println("Starting "+" Service on address: "+service.getAddress() +" and port: "+service.getPort());
        current = service;
        channel = ManagedChannelBuilder.forAddress(service.getAddress(), service.getPort())
                .usePlaintext(true)
                .build();
        if(service.getPort() == 50000){
            System.out.println("SmartCooker service added on port "+service.getPort());
            cookerBlockingStub = SmartCookerGrpc.newBlockingStub(channel);
        }
        else if(service.getPort() == 50001){
            System.out.println("GUI Controller service added on port "+service.getPort());
            blockingStub = GUIControllerGrpc.newBlockingStub(channel);
        }
    }
    
    public boolean interested(String type) {
        return serviceType.equals(type);
    }

    public String getName() {
        return name;
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    /**
     * Send 'switchOn' request to the CookerServer
     */
    
    public void switchCookerOn(){
        System.out.println("Switching the cooker on...");
        try {
            Empty request = Empty.newBuilder().build();
            CookerStatus status = cookerBlockingStub.switchOn(request);
        } catch (RuntimeException e) {
            logger.log(Level.WARNING, "RPC failed", e);
            return;
        }
    }
    
    public void switchOn() {
        System.out.println("Switching the controller on...");
        try {
            Empty request = Empty.newBuilder().build();
            ControllerStatus status = blockingStub.switchOn(request);
            System.out.println("The controler is now: " + status.getStatusMessage());
        } catch (RuntimeException e) {
            logger.log(Level.WARNING, "RPC failed", e);
            return;
        }
    }
    
    public void switchOff() {
        System.out.println("Switching the controller off...");
//        stopHeating();
        try {
            Empty request = Empty.newBuilder().build();
            ControllerStatus status = blockingStub.switchOff(request);
            System.out.println("The controler is now: " + status.getStatusMessage());
        } catch (RuntimeException e) {
            logger.log(Level.WARNING, "RPC failed", e);
            return;
        }
    }
    
//    public void showStatus() {        
//        try {
//            Empty request = Empty.newBuilder().build();
//            CookerStatus status = blockingStub.cookerStatus(request);
//            System.out.println("The cooker's status is: " + status.getStatusMessage());
//            System.out.println("The cooker's temperature is: " + status.getTemperature());
//
//        } catch (RuntimeException e) {
//            logger.log(Level.WARNING, "RPC failed", e);
//            return;
//        }
//    }
//    
//    public void startHeating() {
//        System.out.println("Heating started ...");
//        try {
//            new Thread() {
//                public void run() {
//                    Empty request = Empty.newBuilder().build();
//
//                    Iterator<CookerStatus> response = blockingStub.startHeating(request);
//                    while (response.hasNext()) {
//                        System.out.println(response.next().toString());
//                    }
////                  System.out.println("Cooker is now at 100% temperature...");
//                }
//            }.start();
//
//            Empty request = Empty.newBuilder().build();
//            CookerStatus status = blockingStub.cookerStatus(request);
////            System.out.println("Cooker status: " + status);
//
//        } catch (RuntimeException e) {
//            logger.log(Level.WARNING, "RPC failed", e);
//            return;
//        }
//    }
//    
//    public void stopHeating() {
//        System.out.println("Cooldown started...");
//        try {
//            new Thread() {
//                public void run() {
//                    Empty request = Empty.newBuilder().build();
//
//                    Iterator<CookerStatus> response = blockingStub.stopHeating(request);
//                    while (response.hasNext()) {
//                        System.out.println(response.next().toString());
//                    }
////                    System.out.println("Cooker is now at 0% temperature...");
//                }
//            }.start();
//
//            Empty request = Empty.newBuilder().build();
//            CookerStatus status = blockingStub.cookerStatus(request);
//            System.out.println("Cooker status: " + status);
//
//        } catch (RuntimeException e) {
//            logger.log(Level.WARNING, "RPC failed", e);
//            return;
//        }
//    }
    
    
    public void switchService(String name) {
        // TODO
    }

    public static void main(String[] args) {
        ControllerClient client = new ControllerClient();
        //client.switchOn();

    }
}
