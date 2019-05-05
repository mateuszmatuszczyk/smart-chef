/**
 * @author Mateusz Matuszczyk
 */
package com.mateuszmatuszczyk.smartchef.gui_controller;

import com.mateuszmatuszczyk.smartchef.SmartCookerGrpc;
import com.mateuszmatuszczyk.smartchef.SmartPotGrpc;
import com.mateuszmatuszczyk.smartchef.GUIControllerGrpc;
import com.mateuszmatuszczyk.smartchef.CookerStatus;
import com.mateuszmatuszczyk.smartchef.PotStatus;
import com.mateuszmatuszczyk.smartchef.ControllerStatus;
import com.mateuszmatuszczyk.jmdns.jmDNSServiceTracker;
import com.mateuszmatuszczyk.jmdns.ServiceDescription;
import com.mateuszmatuszczyk.jmdns.ServiceObserver;

import com.google.protobuf.Empty;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import java.awt.Color;

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
    private SmartPotGrpc.SmartPotBlockingStub potBlockingStub;
    
    private boolean cookerStatusOnOff = false;
    private boolean potStatusOnOff = false;
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
        serviceAdded(new ServiceDescription("localhost", 50000));
        serviceAdded(new ServiceDescription("localhost", 50001));
        serviceAdded(new ServiceDescription("localhost", 50002));
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
        System.out.println("Starting "+" Service on address: "+service.getAddress() +" and port: "+service.getPort());
        current = service;
        
        channel = ManagedChannelBuilder.forAddress(service.getAddress(), service.getPort())
                .usePlaintext(true)
                .build();
        if(service.getPort() == 50001){
            System.out.println("SmartCooker service added on port "+service.getPort());
            cookerBlockingStub = SmartCookerGrpc.newBlockingStub(channel);
        }
        else if(service.getPort() == 50000){
            System.out.println("GUI Controller service added on port "+service.getPort());
            blockingStub = GUIControllerGrpc.newBlockingStub(channel);
        }
        else if(service.getPort() == 50002){
            System.out.println("SmartPot service added on port "+service.getPort());
            potBlockingStub = SmartPotGrpc.newBlockingStub(channel);
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
 * GUI Controller Methods Implementation
 */
    public void switchOn() {
        System.out.println("Switching the controller on...");
        try {
            controller_gui.progressBar.setValue(40);
            Empty request = Empty.newBuilder().build();
            ControllerStatus status = blockingStub.switchOn(request);
            System.out.println("The controler is now: " + status.getStatusMessage());
            controller_gui.append(status.getStatusMessage());
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
            controller_gui.append(status.getStatusMessage());
        } catch (RuntimeException e) {
            logger.log(Level.WARNING, "RPC failed", e);
            return;
        }
    }

/**
 * SmartCooker Methods Implementation
 */ 
    public void getCookerStatus() {        
        try {
            Empty request = Empty.newBuilder().build();
            CookerStatus status = cookerBlockingStub.cookerStatus(request);
            cookerStatusOnOff = status.getStatusOnOff();
            if(cookerStatusOnOff == true)
            System.out.println("The cooker's status is: " + status.getStatusOnOff());
            System.out.println("The cooker's temperature is: " + status.getTemperature());

        } catch (RuntimeException e) {
            logger.log(Level.WARNING, "RPC failed", e);
            return;
        }
    }
    public boolean getCookerStatusOnOff(){
        return cookerStatusOnOff;
    }
    public void switchCookerOn(){
        controller_gui.append("Switching the SmartCooker on...");
        System.out.println("Switching the SmartCooker on...");
        try {
            Empty request = Empty.newBuilder().build();
            CookerStatus status = cookerBlockingStub.switchOn(request);
            cookerStatusOnOff = status.getStatusOnOff();
            controller_gui.append(status.getStatusMsg());
        } catch (RuntimeException e) {
            logger.log(Level.WARNING, "RPC failed", e);
            return;
        }
    }  
    public void switchCookerOff(){
        controller_gui.append("Switching the SmartCooker off...");
        System.out.println("Switching the SmartCooker off...");
        try {
            Empty request = Empty.newBuilder().build();
            CookerStatus status = cookerBlockingStub.switchOff(request);
            cookerStatusOnOff = status.getStatusOnOff();
            controller_gui.append(status.getStatusMsg());
        } catch (RuntimeException e) {
            logger.log(Level.WARNING, "RPC failed", e);
            return;
        }
    }
    
    public void startHeating() {
        System.out.println("Heating started ...");
        controller_gui.append("Heating started...");
        try {
            new Thread() {
                public void run() {
                    Empty request = Empty.newBuilder().build();

                    Iterator<CookerStatus> response = cookerBlockingStub.startHeating(request);
                    while (response.hasNext()) {
                        int temperature = response.next().getTemperature();
                        controller_gui.progressBar.setValue(temperature);
                        if (temperature == 100){
//                            controller_gui.progressBar.setBackground(Color.ORANGE);
                            controller_gui.progressBar.setString("Heating Completed");
                        }
                        controller_gui.append("Temp: "+temperature);
                        
                        System.out.println(response.next().toString());
                    }
//                  System.out.println("Cooker is now at 100% temperature...");
                }
            }.start();

            Empty request = Empty.newBuilder().build();
            CookerStatus status = cookerBlockingStub.cookerStatus(request);
//            System.out.println("Cooker status: " + status);

        } catch (RuntimeException e) {
            logger.log(Level.WARNING, "RPC failed", e);
            return;
        }
    }
    
/**
 * SmartPot Methods Implementation
 */
    public void switchPotOn(){
        controller_gui.append("Switching the SmartPot on...");
        System.out.println("Switching the SmartPot on...");
        try {
            Empty request = Empty.newBuilder().build();
            PotStatus status = potBlockingStub.switchOn(request);
            potStatusOnOff = status.getStatusOnOff();
            controller_gui.append(status.getStatusMsg());
        } catch (RuntimeException e) {
            logger.log(Level.WARNING, "RPC failed", e);
            return;
        }
    }  
    public void switchPotOff(){
        controller_gui.append("Switching the SmartPot off...");
        System.out.println("Switching the SmartPot off...");
        try {
            Empty request = Empty.newBuilder().build();
            PotStatus status = potBlockingStub.switchOff(request);
            potStatusOnOff = status.getStatusOnOff();
            controller_gui.append(status.getStatusMsg());
        } catch (RuntimeException e) {
            logger.log(Level.WARNING, "RPC failed", e);
            return;
        }
    }
    
    public void getPotStatus() {        
        try {
            Empty request = Empty.newBuilder().build();
            PotStatus status = potBlockingStub.potStatus(request);
            potStatusOnOff = status.getStatusOnOff();
            if(potStatusOnOff == true)
            System.out.println("The SmartPot's status is: " + status.getStatusOnOff());
            System.out.println("The SmartPot's water lever is is: " + status.getWaterLevel());

        } catch (RuntimeException e) {
            logger.log(Level.WARNING, "RPC failed", e);
            return;
        }
    }
    public boolean getPotStatusOnOff(){
        return potStatusOnOff;
    } 
    
    public void switchService(String name) {
        // TODO
    }

    public static void main(String[] args) {
        ControllerClient client = new ControllerClient();
        //client.switchOn();

    }
}
