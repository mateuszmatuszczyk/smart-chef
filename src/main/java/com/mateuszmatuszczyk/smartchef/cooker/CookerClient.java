/**
 * @author Mateusz Matuszczyk
 */
package com.mateuszmatuszczyk.smartchef.cooker;

import com.mateuszmatuszczyk.smartchef.SmartCookerGrpc;
import com.mateuszmatuszczyk.smartchef.CookerStatus;
import com.mateuszmatuszczyk.jmdns.jmDNSServiceTracker;
import com.mateuszmatuszczyk.jmdns.ServiceDescription;
import com.mateuszmatuszczyk.jmdns.ServiceObserver;

import com.google.protobuf.Empty;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import javax.swing.JPanel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

// import clientui.BedClientGUI;

public class CookerClient implements ServiceObserver {
    
    protected ServiceDescription current;
    private final String serviceType;
    private final String name;
    private static final Logger logger = Logger.getLogger(CookerClient.class.getName());

    private ManagedChannel channel;
    private SmartCookerGrpc.SmartCookerBlockingStub blockingStub;

    /**
     * Constructor.
     */
    public CookerClient() {
        serviceType = "_cooker._udp.local.";
        name = "Smart Cooker";
        jmDNSServiceTracker clientManager = jmDNSServiceTracker.getInstance();
        clientManager.register(this);
        // java.awt.EventQueue.invokeLater(new Runnable() {
        //     public void run() {
        //         ui = new BedClientGUI(BedClient.this);
        //         ui.setVisible(true);
        //     }
        // });
        serviceAdded(new ServiceDescription("localhost", 50000));
    }

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
        System.out.println("Starting Service on address: "+service.getAddress());
        current = service;
        channel = ManagedChannelBuilder.forAddress(service.getAddress(), service.getPort())
                .usePlaintext(true)
                .build();
        blockingStub = SmartCookerGrpc.newBlockingStub(channel);
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
    public void switchOn(){
        System.out.println("Switching the cooker on...");
        //startHeating();
        try {
            Empty request = Empty.newBuilder().build();
            CookerStatus status = blockingStub.switchOn(request);
        } catch (RuntimeException e) {
            logger.log(Level.WARNING, "RPC failed", e);
            return;
        }
    }
    
    public void switchOff() {
        System.out.println("Switching the cooker off...");
        stopHeating();
        try {
            Empty request = Empty.newBuilder().build();
            CookerStatus status = blockingStub.switchOff(request);
            System.out.println("The cooker is now: " + status.getStatusMessage());
        } catch (RuntimeException e) {
            logger.log(Level.WARNING, "RPC failed", e);
            return;
        }
    }
    
    public void showStatus() {        
        try {
            Empty request = Empty.newBuilder().build();
            CookerStatus status = blockingStub.cookerStatus(request);
            System.out.println("The cooker's status is: " + status.getStatusMessage());
            System.out.println("The cooker's temperature is: " + status.getTemperature());

        } catch (RuntimeException e) {
            logger.log(Level.WARNING, "RPC failed", e);
            return;
        }
    }
    
    public void startHeating() {
        System.out.println("Heating started ...");
        try {
            new Thread() {
                public void run() {
                    Empty request = Empty.newBuilder().build();

                    Iterator<CookerStatus> response = blockingStub.startHeating(request);
                    while (response.hasNext()) {
                        System.out.println(response.next().toString());
                    }
//                  System.out.println("Cooker is now at 100% temperature...");
                }
            }.start();

            Empty request = Empty.newBuilder().build();
            CookerStatus status = blockingStub.cookerStatus(request);
//            System.out.println("Cooker status: " + status);

        } catch (RuntimeException e) {
            logger.log(Level.WARNING, "RPC failed", e);
            return;
        }
    }
    
    public void stopHeating() {
        System.out.println("Cooldown started...");
        try {
            new Thread() {
                public void run() {
                    Empty request = Empty.newBuilder().build();

                    Iterator<CookerStatus> response = blockingStub.stopHeating(request);
                    while (response.hasNext()) {
                        System.out.println(response.next().toString());
                    }
//                    System.out.println("Cooker is now at 0% temperature...");
                }
            }.start();

            Empty request = Empty.newBuilder().build();
            CookerStatus status = blockingStub.cookerStatus(request);
            System.out.println("Cooker status: " + status);

        } catch (RuntimeException e) {
            logger.log(Level.WARNING, "RPC failed", e);
            return;
        }
    }
    
    
    public void switchService(String name) {
        // TODO
    }

    public static void main(String[] args) throws InterruptedException {
        CookerClient client = new CookerClient();
//        logger.log(Level.INFO, "Checking cooker's status...");
//        client.showStatus();
//        System.out.println("Switching the cooker on...");
        client.switchOn();
        
//        client.switchOff();
        
//        System.out.println("Starting heating the cooker up...");
//        client.startHeating();
        
//        client.stopHeating();
//        client.showStatus();
    }
}

