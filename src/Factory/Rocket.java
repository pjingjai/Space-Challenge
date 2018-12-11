package Factory;

import Mission.Item;
import java.util.ArrayList;

public class Rocket implements SpaceShip {
    int rocketCost;
    public int getRocketCost() {
        return rocketCost;
    }
    int rocketWeight;
    public int getRocketWeight() {
        return rocketWeight;
    }
    int maxWeight;
    public int getMaxWeight() {
        return maxWeight;
    }
    int cLaunchExplosion;
    int cLandingCrash;

    ArrayList<Item> cargo;
    public ArrayList<Item> getCargo() {
        return cargo;
    }
    public void setCargo(ArrayList<Item> listCargo) {
        cargo = listCargo;
    }

    public void addCargo(Item item) {
        cargo.add(item);

    }

    boolean explode() {
        if (Math.random()*100 < cLaunchExplosion) {     // explode
            return true;
        } else {
            return  false;
        }
    }
    boolean crash() {
        if (Math.random()*100 < cLandingCrash) {     // crash
            return true;
        } else {
            return  false;
        }
    }

    public boolean launch(){
        return true;
    }
    public boolean land() {
        return true;
    }
    public boolean canCarry() {
        if (rocketWeight < maxWeight) {
            return true;
        }
        else {
            return false;
        }

    }
    public int carry(Item item) {
        rocketWeight += item.getWeight();
        addCargo(item);
        return rocketWeight;
    }
}
