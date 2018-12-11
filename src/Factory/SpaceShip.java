package Factory;

interface SpaceShip {
    boolean launch();
    boolean land();
    boolean canCarry();
    int carry(Mission.Item item);
}
