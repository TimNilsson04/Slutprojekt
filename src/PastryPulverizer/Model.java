package PastryPulverizer;
import PastryPulverizer.Buildings.*;

public class Model {

    Pulverizer Pulverizer = new Pulverizer();
    PastryBaker PastryBaker = new PastryBaker();

    int pastries = 0;

    public void addPastries(){
        pastries++;
    }

    public String getMoney() {
        String money = pastries + " Pastries";
        return money;
    }
}
