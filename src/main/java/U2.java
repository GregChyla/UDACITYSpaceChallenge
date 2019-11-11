class U2 extends Rocket {
    U2() {
        costInMillions = 120;
        maxWeightWithCargo = 29000;
        weight = 18000;
        launchExplosionChance = 0.04;
        landCrashChance = 0.08;
        cargoLoaded = 0;
    }

    U2(int cargoLoaded) {
        costInMillions = 120;
        maxWeightWithCargo = 29000;
        weight = 18000;
        launchExplosionChance = 0.04;
        landCrashChance = 0.08;
        this.cargoLoaded = cargoLoaded;
    }
}
