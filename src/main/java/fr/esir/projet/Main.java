package fr.esir.projet;

import tuwien.auto.calimero.KNXException;

public class Main
{

    public static void main(final String[] args) throws KNXException, InterruptedException {
        KNX home=new KNX("192.168.1.106","192.168.1.201",3671);
        home.chenillard();

        Thread.sleep(20000);

    }
}


