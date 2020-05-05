package server.dto;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ChenillardJson {

    private int vitesse=0;
    private boolean run=false;
    private int sens=1;

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

    public void setRun(boolean run) {
        this.run = run;
    }

    public void setSens(int sens) {
        this.sens = sens;
    }

    @Override
    public String toString() {
        return "Chenillard [vitesse=" + vitesse + ", run=" + run + ", sens="
                + sens + "]";
    }
}
