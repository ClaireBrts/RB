package fr.esir.projet;

import tuwien.auto.calimero.GroupAddress;
import tuwien.auto.calimero.KNXFormatException;
import tuwien.auto.calimero.KNXTimeoutException;
import tuwien.auto.calimero.link.KNXLinkClosedException;
import tuwien.auto.calimero.process.ProcessCommunicator;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.concurrent.TimeUnit;

@XmlRootElement
public class Chenillard extends Thread {
    private int vitesse;
    private boolean run;
    private int sens;
    private ProcessCommunicator pc;

    public Chenillard(ProcessCommunicator pc, int vitesse, int sens) {
        this.vitesse = vitesse;
        this.sens = sens;
        this.pc = pc;
        this.run = true;
    }

    @Override
    public void run() {
        int i = 1;
        while (run) {
            //System.out.println("dans le while du chenillard"+ run);
            try {
                if (sens == 1) {
                    if (i == 5) {
                        i = 1;
                    }
                    pc.write(new GroupAddress("0/0/" + i), true);
                    TimeUnit.MILLISECONDS.sleep(vitesse);
                    pc.write(new GroupAddress("0/0/" + i), false);
                    TimeUnit.MILLISECONDS.sleep(vitesse);
                    i++;
                } else {
                    System.out.println("sens inverse");
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


    public void accelerer() {
        if (vitesse >= 300) {
            vitesse -= 100;
        }
    }

    public void accelerer(int vit) {
        if (vitesse >= 300) {
            vitesse -= vit;
        }
    }

    public void ralentir() { vitesse += 100; }

    public void ralentir(int vit) {
        vitesse += vit;
    }


    public void changementSens() {
        if (sens == 1) {
            sens = -1;
        } else {
            sens = 1;
        }
    }

    public int getVitesse() {
        return vitesse;
    }

    public boolean isRun() {
        return run;
    }

    public int getSens() {
        return sens;
    }

    public void setVitesse(int vitesse) {
        this.vitesse = vitesse;
    }

    public void setSens(int sens) {
        this.sens = sens;
    }

    public void setRun(boolean run) {
        this.run = run;
    }

    @Override
    public String toString() {
        return "Chenillard [vitesse=" + vitesse + ", run=" + run + ", sens="
                + sens + "]";
    }
}
