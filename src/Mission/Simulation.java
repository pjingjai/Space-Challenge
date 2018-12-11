package Mission;
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import Factory.*;

public class Simulation {
    private File file;
    private Scanner scanner;

    ArrayList<Item> listReqPhase1 = new ArrayList<Item>();
    private ArrayList<Item> listReqPhase2 = new ArrayList<Item>();

    private ArrayList<Rocket> listU1Ph1 = new ArrayList<Rocket>();
    private ArrayList<Rocket> listU1Ph2 = new ArrayList<Rocket>();
    ArrayList<Rocket> listU2Ph1 = new ArrayList<Rocket>();
    private ArrayList<Rocket> listU2Ph2 = new ArrayList<Rocket>();

    private ArrayList<Item> listAvailResources1 = new ArrayList<Item>();
    private ArrayList<Item> listAvailResources2 = new ArrayList<Item>();

    private int totalBudget;

    public ArrayList<Item> readReq(int phase) {
        try {

            if (phase == 1) {
                file = new File("C:\\Users\\pun\\IdeaProjects\\Space Challenge\\src\\Mission\\Mission to Mars\\phase-1.txt");
                scanner = new Scanner(file);
                while (scanner.hasNextLine()) {     //read and cast each line to String&int
                    String line = scanner.nextLine();
                    String itemName = line.substring(0, line.indexOf("="));     // itemName
                    String s2 = line.substring(line.indexOf("=") + 1);        // weight
                    int weight = Integer.parseInt(s2);      // weight

                    boolean toMakeNew = true;
                    if (!listReqPhase1.isEmpty()) {
                        int j = 0;
                        while (j < listReqPhase1.size()) {
                            if (itemName.equals(listReqPhase1.get(j).getName())) {      // if equal
                                listReqPhase1.get(j).addWeight(weight);
                                toMakeNew = false;
                                j = listReqPhase1.size();
                            }
                            j++;
                        }
                    }
                    if (toMakeNew){       // if not equal
                        Item cargo = new Item(itemName, weight);
                        listReqPhase1.add(cargo);
                    }
                }
                scanner.close();
                return listReqPhase1;
            }
            else if (phase == 2) {
                file = new File("C:\\Users\\pun\\IdeaProjects\\Space Challenge\\src\\Mission\\Mission to Mars\\phase-2.txt");
                scanner = new Scanner(file);
                while (scanner.hasNextLine()) {     //read and cast each line to String&int
                    String line = scanner.nextLine();
                    String itemName = line.substring(0, line.indexOf("="));     // itemName
                    String s2 = line.substring(line.indexOf("=") + 1);        // weight
                    int weight = Integer.parseInt(s2);      // weight

                    boolean toMakeNew = true;
                    if (!listReqPhase2.isEmpty()) {
                        int j = 0;
                        while (j < listReqPhase2.size()) {
                            if (itemName.equals(listReqPhase2.get(j).getName())) {      // if equal
                                listReqPhase2.get(j).addWeight(weight);
                                toMakeNew = false;
                                j = listReqPhase2.size();
                            }
                            j++;
                        }
                    }
                    if (toMakeNew) {       // if not equal
                        Item cargo = new Item(itemName, weight);
                        listReqPhase2.add(cargo);
                    }
                }
                scanner.close();
                return listReqPhase2;
            }
        }

        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Item> loadItems(String doc, int phase) {
        try {
                if (phase == 1) {
                file = new File(doc);
                scanner = new Scanner(file);
                while (scanner.hasNextLine()) {     //read and cast each line to String&int
                    String line = scanner.nextLine();
                    String itemName = line.substring(0, line.indexOf("="));     // itemName
                    String s2 = line.substring(line.indexOf("=") + 1);        // weight
                    int weight = Integer.parseInt(s2);      // weight

                    boolean toMakeNew = true;
                    if (!listAvailResources1.isEmpty()) {
                        int j = 0;
                        while (j < listAvailResources1.size()) {
                            if (itemName.equals(listAvailResources1.get(j).getName())) {      // if equal
                                listAvailResources1.get(j).addWeight(weight);
                                toMakeNew = false;
                                j = listAvailResources1.size();
                            }
                            j++;
                        }
                    }
                    if (toMakeNew) {       // if not equal
                        Item cargo = new Item(itemName, weight);
                        listAvailResources1.add(cargo);
                    }
                }
                    return listAvailResources1;
            }
            if (phase == 2) {
                file = new File(doc);
                scanner = new Scanner(file);
                while (scanner.hasNextLine()) {     //read and cast each line to String&int
                    String line = scanner.nextLine();
                    String itemName = line.substring(0, line.indexOf("="));     // itemName
                    String s2 = line.substring(line.indexOf("=") + 1);        // weight
                    int weight = Integer.parseInt(s2);      // weight

                    boolean toMakeNew = true;
                    if (!listAvailResources2.isEmpty()) {
                        int j = 0;
                        while (j < listAvailResources2.size()) {
                            if (itemName.equals(listAvailResources2.get(j).getName())) {      // if equal
                                listAvailResources2.get(j).addWeight(weight);
                                toMakeNew = false;
                                j = listAvailResources2.size();
                            }
                            j++;
                        }
                    }
                    if (toMakeNew) {       // if not equal
                        Item cargo = new Item(itemName, weight);
                        listAvailResources2.add(cargo);
                    }
                }
            }

        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return listAvailResources2;
    }

    public ArrayList<Rocket> loadU1(int phase) {
        Rocket r0 = new U1();
        final int r0MaxCargo = r0.getMaxWeight() - r0.getRocketWeight();
        int reqCargoWeight = 0;
        ArrayList<Item> listLoadedItem = new ArrayList<Item>();
        int currentWeight = 0;
        Item forLoading = new Item();
        int availRocket = 0;

        if (phase == 1) {
            for (Item cargo: listReqPhase1) {
                reqCargoWeight += cargo.getWeight();
            }
            for (Item cargo: listReqPhase1) {
                int portion = (int)((double)(cargo.getWeight()) / (double)(reqCargoWeight) * r0MaxCargo);
                forLoading = new Item(cargo.getName(), portion);
                //if (currentWeight+forLoading.getWeight() <= r0MaxCargo) {
                    listLoadedItem.add(forLoading);
                    currentWeight += forLoading.getWeight();
                //}
                /*else {
                    forLoading.setWeight(r0MaxCargo-currentWeight);
                    listLoadedItem.add(forLoading);
                }*/
            }
            r0.setCargo(listLoadedItem);
            availRocket = listAvailResources1.get(0).getWeight() / listLoadedItem.get(0).getWeight();
            for (int i=1; i<listAvailResources1.size()-1; i++){
                int temp = listAvailResources1.get(i).getWeight() / listLoadedItem.get(i).getWeight();
                if (temp < availRocket) {
                    availRocket = temp;
                }
            }
            for (int i=0; i<availRocket; i++) {
                listU1Ph1.add(r0);
            }

            return listU1Ph1;
        }

        if (phase == 2) {
            for (Item cargo: listReqPhase2) {
                reqCargoWeight += cargo.getWeight();
            }
            for (Item cargo: listReqPhase2) {
                int portion = (int)((double)(cargo.getWeight()) / (double)(reqCargoWeight) * r0MaxCargo);
                forLoading = new Item(cargo.getName(), portion);
                //if (currentWeight+forLoading.getWeight() <= r0MaxCargo) {
                    listLoadedItem.add(forLoading);
                    currentWeight += forLoading.getWeight();
                //}
                /*else {
                    forLoading.setWeight(r0MaxCargo-currentWeight);
                    listLoadedItem.add(forLoading);
                }*/
            }
            r0.setCargo(listLoadedItem);
            availRocket = listAvailResources2.get(0).getWeight() / listLoadedItem.get(0).getWeight();
            for (int i=1; i<listAvailResources2.size()-1; i++){
                int temp = listAvailResources2.get(i).getWeight() / listLoadedItem.get(i).getWeight();
                if (temp < availRocket) {
                    availRocket = temp;
                }
            }
            for (int i=0; i<availRocket; i++) {
                listU1Ph2.add(r0);
            }

            return listU1Ph2;
        }

        return null;
    }

    private boolean done1() {
        for (Item each: listReqPhase1) {
            if (each.getWeight() > 0) {
                return false;
            }
            else {
                return true;
            }
        }
        return false;
    }
    private boolean done2() {
        for (Item each: listReqPhase2) {
            if (each.getWeight() > 0) {
                return false;
            }
            else {
                return true;
            }
        }
        return false;
    }

    public int runSimulation(ArrayList<Rocket> listRocket, ArrayList<Rocket> listRocket1) {

        loop: while (!done1()) {

                if (listRocket.get(0).launch()) {    // if launch succeed
                    if (listRocket.get(0).land()) {     // if land succeed
                        for (int i=0;i<7;i++) {
                            listReqPhase1.get(i).setWeight(listReqPhase1.get(i).getWeight() - listRocket.get(0).getCargo().get(i).getWeight());

                        }
                        totalBudget += listRocket.get(0).getRocketCost();
                        listRocket.remove(0);
                        if (listRocket.isEmpty())
                            break loop;
                    }
                    else {      // if land fail
                        listRocket.remove(0);
                        if (listRocket.isEmpty())
                            break loop;
                        totalBudget += listRocket.get(0).getRocketCost();
                    }
                }
                else {      // if launch fail
                    listRocket.remove(0);
                    totalBudget += listRocket.get(0).getRocketCost();
                }
        }

        loop: while (!done2()) {

            if (listRocket1.get(0).launch()) {    // if launch succeed
                if (listRocket1.get(0).land()) {     // if land succeed
                    for (int i=0;i<3;i++) {
                        listReqPhase2.get(i).setWeight(listReqPhase2.get(i).getWeight() - listRocket1.get(0).getCargo().get(i).getWeight());

                    }
                    totalBudget += listRocket1.get(0).getRocketCost();
                    listRocket1.remove(0);
                    if (listRocket1.isEmpty())
                        break loop;
                }
                else {      // if land fail
                    listRocket1.remove(0);
                    if (listRocket1.isEmpty())
                        break loop;
                    totalBudget += listRocket1.get(0).getRocketCost();
                }
            }
            else {      // if launch fail
                listRocket1.remove(0);
                totalBudget += listRocket1.get(0).getRocketCost();
            }
        }

        if (listRocket.isEmpty() && !listReqPhase1.isEmpty() || listRocket1.isEmpty() && !listReqPhase2.isEmpty()) {
            System.out.println("Mission fail");
        }
        return totalBudget;
    }

}   // end class
