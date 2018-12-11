package Mission;

import java.util.ArrayList;
import Factory.*;

public class Main {
    public static void main(String[] args)  {
        Simulation s = new Simulation();
        ArrayList<Rocket> r1;
        ArrayList<Rocket> r2;
        int total;

        s.readReq(1);
        s.readReq(2);

        s.loadItems("C:\\Users\\pun\\IdeaProjects\\Space Challenge\\src\\Mission\\Mission to Mars\\resources-1.txt", 1);
        s.loadItems("C:\\Users\\pun\\IdeaProjects\\Space Challenge\\src\\Mission\\Mission to Mars\\resources-2.txt", 2);

        r1 = s.loadU1(1);
        r2 = s.loadU1(2);

        total = s.runSimulation(r1, r2);
        System.out.println(total);
    }
}
