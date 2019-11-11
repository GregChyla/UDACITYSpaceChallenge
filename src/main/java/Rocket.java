class Rocket implements SpaceShip {

    int costInMillions;
    int weight;
    int maxWeightWithCargo;
    double launchExplosionChance;
    double landCrashChance;
    int cargoLoaded;

    Rocket(int cargoLoaded) {
        this.cargoLoaded = cargoLoaded;
    }

    Rocket() {

    }

    @Override
    public String toString() {
        return "Rocket info: cost: " + costInMillions +
                " weight: " + weight +
                " max weight with cargo: " + maxWeightWithCargo +
                " cargo loaded: " + cargoLoaded;
    }

    @Override
    public boolean launch(SpaceShip spaceShip) {
        double random = (int) (Math.random() * 100 * launchExplosionChance);
        //System.out.println("Random in launch: " + random); //TODO delete
        return random > 0;
    }

    @Override
    public boolean land(SpaceShip spaceShip) {
        double random = (int) (Math.random() * 100 * landCrashChance);
        System.out.println("Random in land: " + random); //TODO delete
        return random > 0;
    }

    // check if item's weight is lower than space left
    @Override
    public final boolean canCarry(Item item) {
        return item.weight <= (maxWeightWithCargo - weight - cargoLoaded);
    }

    // load item to rocket
    @Override
    public final void carry(Item item) {
        if (canCarry(item)) {
            cargoLoaded += item.weight;
        }
    }
}
