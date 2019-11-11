interface SpaceShip {

    default boolean launch(SpaceShip spaceShip){
        return true;
    }

    default boolean land(SpaceShip spaceShip) {
        return true;
    }

    boolean canCarry(Item item);

    void carry(Item item);

}
