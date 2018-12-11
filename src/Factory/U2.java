package Factory;

public class U2 extends Rocket {
    public U2() {
        rocketCost = 120;
        rocketWeight = 18000;
        maxWeight = 29000;
        cLaunchExplosion = 4;
        cLandingCrash = 8;
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
