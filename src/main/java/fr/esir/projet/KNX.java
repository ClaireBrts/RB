package fr.esir.projet;

import tuwien.auto.calimero.*;
import tuwien.auto.calimero.cemi.CEMILData;
import tuwien.auto.calimero.link.KNXLinkClosedException;
import tuwien.auto.calimero.link.KNXNetworkLink;
import tuwien.auto.calimero.link.KNXNetworkLinkIP;
import tuwien.auto.calimero.link.NetworkLinkListener;
import tuwien.auto.calimero.link.medium.TPSettings;
import tuwien.auto.calimero.process.ProcessCommunicator;
import tuwien.auto.calimero.process.ProcessCommunicatorImpl;

import java.net.InetSocketAddress;
import java.util.concurrent.TimeUnit;

import static tuwien.auto.calimero.link.medium.TPSettings.TP1;

//IP : 192.168.1.201
//WIFI Esir-Maquette114

public class KNX {


    private InetSocketAddress local;
    private InetSocketAddress server;

    private KNXNetworkLink knxLink;

    private ProcessCommunicator pc;
    private boolean stopChenillard;
    private int onLight; //determine si les lumieres sont allumes (true) ou eteinte (false)

    public KNX(String localAdress, String destAdress, int port) throws KNXException, InterruptedException {
        local = new InetSocketAddress(localAdress, port);
        server = new InetSocketAddress(destAdress, port);

        System.out.println("This example establishes a tunneling connection to the KNXnet/IP server " + server);

        knxLink = KNXNetworkLinkIP.newTunnelingLink(local, server, false, new TPSettings());
        System.out.println("Connection established to server " + knxLink.getName());

        pc = new ProcessCommunicatorImpl(knxLink);
        allLightOff();
        onLight=0;


        knxLink.addLinkListener(new NetworkLinkListener(){
            public void confirmation(FrameEvent arg0) {
            }

            public void indication(FrameEvent arg0) {

                if(((CEMILData)arg0.getFrame()).getDestination().toString().equals("1/0/3")){
                    onLight++;
                }
                if(onLight==2){
                    try {
                        allLightOn();
                    } catch (KNXFormatException e) {
                        e.printStackTrace();
                    } catch (KNXTimeoutException e) {
                        e.printStackTrace();
                    } catch (KNXLinkClosedException e) {
                        e.printStackTrace();
                    }
                }
                if(onLight==4){

                    try {
                        allLightOff();

                    } catch (KNXFormatException e) {
                        e.printStackTrace();
                    } catch (KNXTimeoutException e) {
                        e.printStackTrace();
                    } catch (KNXLinkClosedException e) {
                        e.printStackTrace();
                    }
                    onLight=0;
                }

                //System.out.println("targetadress " + ((CEMILData)arg0.getFrame()).getDestination());
            }

            public void linkClosed(CloseEvent arg0) {
                System.out.println("linkclosed");

            }

        });

    }

    public void deconnection() {
        knxLink.close();
    }

    public void allLightOn() throws KNXFormatException, KNXTimeoutException, KNXLinkClosedException {
        pc.write(new GroupAddress("0/0/1"), true);
        pc.write(new GroupAddress("0/0/2"), true);
        pc.write(new GroupAddress("0/0/3"), true);
        pc.write(new GroupAddress("0/0/4"), true);

    }

    public void allLightOff() throws KNXFormatException, KNXTimeoutException, KNXLinkClosedException {
        pc.write(new GroupAddress("0/0/1"), false);
        pc.write(new GroupAddress("0/0/2"), false);
        pc.write(new GroupAddress("0/0/3"), false);
        pc.write(new GroupAddress("0/0/4"), false);

    }

    public void chenillard() throws KNXFormatException, KNXTimeoutException, KNXLinkClosedException {
        stopChenillard=false;
        int i =1;
            while (!stopChenillard) {
                try {
                    pc.write(new GroupAddress("0/0/" + i), true);
                    TimeUnit.MILLISECONDS.sleep(700);
                    pc.write(new GroupAddress("0/0/" + i), false);
                    TimeUnit.MILLISECONDS.sleep(700);
                    i++;
                    if(i==5){
                        i=0;
                    }
                } catch (InterruptedException e) {
                    System.out.println("Fin chenillard");
                    stopChenillard = true;
                    deconnection();
                }
            }
            
    }

}

