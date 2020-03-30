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
    private int button1;
    private int button2;
    private int button3;
    private int button4;

    private Chenillard chenillard;

    public KNX(String localAdress, String destAdress, int port) throws KNXException, InterruptedException {
        local = new InetSocketAddress(localAdress, port);
        server = new InetSocketAddress(destAdress, port);

        System.out.println("This example establishes a tunneling connection to the KNXnet/IP server " + server);

        knxLink = KNXNetworkLinkIP.newTunnelingLink(local, server, false, new TPSettings());
        System.out.println("Connection established to server " + knxLink.getName());

        pc = new ProcessCommunicatorImpl(knxLink);
        allLightOff();

        button1 = 0;
        button2 = 0;
        button3 = 0;
        button4 = 0;



        knxLink.addLinkListener(new NetworkLinkListener() {
            public void confirmation(FrameEvent arg0) {
            }

            public void indication(FrameEvent arg0) {

                //System.out.println("targetadress " + ((CEMILData)arg0.getFrame()).getDestination());
                System.out.println(button1);

                /**reaction au button1
                 *
                 */
                if (((CEMILData) arg0.getFrame()).getDestination().toString().equals("1/0/1")) {
                    button1++;
                }
                //Premier appui donc lance l'action
                if (button1 == 2) {
                    if(chenillard == null) {
                        chenillard = new Chenillard(pc, 600, 1);
                        chenillard.start();
                    }
                }
                //Deuxième appui donc stop l'action
                if (button1 == 4) {
                    System.out.println("deco chenillard");
                    chenillard.setRun(false);
                    chenillard = null;
                    button1 = 0;
                }

                /**reaction au button2
                 * si button2 = 2 cela veut dire que l'utilisateur a appuié puis relaché le bouton
                 */
                if (((CEMILData) arg0.getFrame()).getDestination().toString().equals("1/0/2")) {
                    button2++;
                }
                //Premier appui donc lance l'action
                if (button2 == 2) {
                    chenillard.changementSens();
                    button2=0;
                }

                /**reaction au button3
                 *
                 */
                if (((CEMILData) arg0.getFrame()).getDestination().toString().equals("1/0/3")) {
                    button3++;
                }
                //Premier appui donc lance l'action
                if (button3 == 2) {
                    chenillard.accelerer();
                    button3=0;
                }


                /**reaction au button4
                 *
                 */
                if (((CEMILData) arg0.getFrame()).getDestination().toString().equals("1/0/4")) {
                    button4++;
                }
                //Premier appui donc lance l'action
                if (button4 == 2) {
                    chenillard.ralentir();
                    button4=0;
                }

            }

            public void linkClosed(CloseEvent arg0) {
                System.out.println("linkclosed");
            }

        });

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

}

