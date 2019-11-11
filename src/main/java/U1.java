class U1 extends Rocket {
    U1() {
        costInMillions = 100;
        maxWeightWithCargo = 18000;
        weight = 10000;
        launchExplosionChance = 0.05;
        landCrashChance = 0.01;
        cargoLoaded = 0;
    }
    U1(int cargoLoaded) {
        costInMillions = 100;
        maxWeightWithCargo = 18000;
        weight = 10000;
        launchExplosionChance = 0.05;
        landCrashChance = 0.01;
        this.cargoLoaded = cargoLoaded;
    }

}
