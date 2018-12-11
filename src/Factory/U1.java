package Factory;

public class U1 extends Rocket {
    public U1() {
        rocketCost = 100;
        rocketWeight = 10000;
        maxWeight = 18000;
        cLaunchExplosion = 5;
        cLandingCrash = 1;
    }

    public boolean launch(){        //false if fail
        if (explode()) {
            return false;
        } else {
            return true;
        }
    }
    public boolean land() {        //false if fail
        if (crash()) {
            return false;
        } else {
            return true;
        }
    }
}
