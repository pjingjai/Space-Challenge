package Mission;

public class Item {

    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    private int weight;
    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Item() {
        name = "";
        weight = 0;
    }

    public Item(int w) {
        name = "";
        weight = w;
    }

    public Item(String n, int w) {
        name = n;
        weight = w;
    }





    public void addWeight(int weight) {
        this.weight += weight;
    }
}
