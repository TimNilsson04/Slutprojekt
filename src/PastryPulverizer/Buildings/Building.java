package PastryPulverizer.Buildings;

public class Building {
    private int Pps;
    private int cost;
    private int owned;


    public int getPps() {
        return Pps;
    }

    public void setPps(int Pps) {
        this.Pps = Pps;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getOwned() {
        return owned;
    }

    public void setOwned(int owned) {
        this.owned = owned;
    }

    public Building(int Pps, int cost, int owned) {
        this.Pps = Pps;
        this.cost = cost;
        this.owned = owned;
    }
}

