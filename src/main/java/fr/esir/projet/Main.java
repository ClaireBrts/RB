package fr.esir.projet;

import tuwien.auto.calimero.KNXException;


public class Main
{

    public static void main(final String[] args) throws KNXException, InterruptedException {
        KNX home=new KNX("192.168.0.29","192.168.1.201",3671);
        Thread.sleep(20000);
    }


}


