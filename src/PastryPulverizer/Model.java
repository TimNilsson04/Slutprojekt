package PastryPulverizer;

public class Model {

    int pastries = 0;

    public void addPastries(){
        pastries++;
    }

    public String getMoney() {
        String money = pastries + " Pastries";
        return money;
    }
}
