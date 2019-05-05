/**
 * @author Mateusz Matuszczyk
 */
package com.mateuszmatuszczyk.smartchef.smart_pot;

import com.mateuszmatuszczyk.smartchef.SmartPotGrpc;
import com.mateuszmatuszczyk.smartchef.PotStatus;
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

public class PotClient implements ServiceObserver {
    
    protected ServiceDescription current;
    private final String serviceType;
    private final String name;
    private static final Logger logger = Logger.getLogger(PotClient.class.getName());

    private ManagedChannel channel;
    private SmartPotGrpc.SmartPotBlockingStub blockingStub;

    /**
     * Constructor.
     */
    public PotClient() {
        serviceType = "_pot._udp.local.";
        name = "Smart Pot";
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
        blockingStub = SmartPotGrpc.newBlockingStub(channel);
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
     * Send 'switchOn' request to the SmartPot server
     */
    public void switchOn(){
        System.out.println("Switching the SmartPot on...");
        try {
            Empty request = Empty.newBuilder().build();
            PotStatus status = blockingStub.switchOn(request);
        } catch (RuntimeException e) {
            logger.log(Level.WARNING, "RPC failed", e);
            return;
        }
    }
    
    public void switchOff() {
        System.out.println("Switching the SmartPot off...");
        try {
            Empty request = Empty.newBuilder().build();
            PotStatus status = blockingStub.switchOff(request);
            System.out.println("The SmartPot is now: " + status.getStatusMsg());
        } catch (RuntimeException e) {
            logger.log(Level.WARNING, "RPC failed", e);
            return;
        }
    }
    
    public void showStatus() {        
        try {
            Empty request = Empty.newBuilder().build();
            PotStatus status = blockingStub.potStatus(request);
            System.out.println("The SmartPot's status is: " + status.getStatusMsg());
            System.out.println("The SmartPot's temperature is: " + status.getTemperature());
            System.out.println("The SmartPot's is covered with the lid: " + status.getLidOn());
            System.out.println("The SmartPot's water level is at : " + status.getWaterLevel()+"%.");

        } catch (RuntimeException e) {
            logger.log(Level.WARNING, "RPC failed", e);
            return;
        }
    }
    
    public void coverWithLid() {
        System.out.println("Covering the pot with lid...");
        try {
            Empty request = Empty.newBuilder().build();

            PotStatus status = blockingStub.coverWithLid(request);
            System.out.println("The pot has been covered with the lid. \nSmartPot's status: " + status);

        } catch (RuntimeException e) {
            logger.log(Level.WARNING, "RPC failed", e);
            return;
        }
    }
    
    public void addWater() {
        System.out.println("Adding water...");
        try {
            new Thread() {
                public void run() {
                    Empty request = Empty.newBuilder().build();

                    Iterator<PotStatus> response = blockingStub.addWater(request);
                    while (response.hasNext()) {
                        System.out.println(response.next().toString());
                    }
//                  System.out.println("Cooker is now at 100% temperature...");
                }
            }.start();

            Empty request = Empty.newBuilder().build();
            PotStatus status = blockingStub.potStatus(request);
//            System.out.println("Cooker status: " + status);

        } catch (RuntimeException e) {
            logger.log(Level.WARNING, "RPC failed", e);
            return;
        }
    }
    
//    public void addWater(Boolean addSalt, int waterVolume) {
//        System.out.println("Adding water to the pot...");
//        try {
//            WaterRequest wr = WaterRequest.newBuilder().setSalted(addSalt).setVolume(waterVolume).build();
//
//            PotStatus status = blockingStub.addWater(wr);
//            System.out.println("Water added. \nSmartPot's status: " + status);
//
//        } catch (RuntimeException e) {
//            logger.log(Level.WARNING, "RPC failed", e);
//            return;
//        }
//    }
    
    
    public void switchService(String name) {
        // TODO
    }

    public static void main(String[] args) throws InterruptedException {
        PotClient client = new PotClient();
//        logger.log(Level.INFO, "Checking cooker's status...");
//        client.showStatus();
//        System.out.println("Switching the cooker on...");
        client.switchOn();
        
        client.switchOff();
        
//        System.out.println("Starting heating the cooker up...");
        client.addWater();
        
        
//        client.stopHeating();
        client.showStatus();
    }
}

