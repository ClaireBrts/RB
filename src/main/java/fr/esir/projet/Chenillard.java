package fr.esir.projet;

import tuwien.auto.calimero.GroupAddress;
import tuwien.auto.calimero.KNXFormatException;
import tuwien.auto.calimero.KNXTimeoutException;
import tuwien.auto.calimero.link.KNXLinkClosedException;
import tuwien.auto.calimero.process.ProcessCommunicator;

import java.util.concurrent.TimeUnit;

public class Chenillard extends Thread {
    private int vitesse;
    private boolean run;
    private int sens;
    private ProcessCommunicator pc;

    public Chenillard(ProcessCommunicator pc, int vitesse, boolean run, int sens) {
        this.vitesse = vitesse;
        this.run = run;
        this.sens = sens;
        this.pc = pc;
    }

    @Override
    public void run() {
        run = true;
        int i = 1;
        while (run) {
            try {
                if (sens == 1) {
                    if (i == 5) {
                        i = 0;
                    }
                    pc.write(new GroupAddress("0/0/" + i), true);
                    TimeUnit.MILLISECONDS.sleep(vitesse);
                    pc.write(new GroupAddress("0/0/" + i), false);
                    TimeUnit.MILLISECONDS.sleep(vitesse);
                    i++;
                } else {
                    if (i == 0) {
                        i = 4;
                    }
                    pc.write(new GroupAddress("0/0/" + i), true);
                    TimeUnit.MILLISECONDS.sleep(vitesse);
                    pc.write(new GroupAddress("0/0/" + i), false);
                    TimeUnit.MILLISECONDS.sleep(vitesse);
                    i--;
                }


            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (KNXFormatException e) {
                e.printStackTrace();
            } catch (KNXTimeoutException e) {
                e.printStackTrace();
            } catch (KNXLinkClosedException e) {
                e.printStackTrace();
            }
        }
    }

    public void chenPause() {
        run = false;
    }

    public void accelerer() {
        if (vitesse >= 300) {
            vitesse -= 100;
        }
    }

    public void relentir() {
        vitesse += 100;
    }

    public void ChangementSens() {
        if (sens == 1) {
            sens = -1;
        } else {
            sens = 1;
        }
    }

}
