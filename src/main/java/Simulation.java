import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class Simulation {

/*
    Filling up Array List of items from a file
    @exception: File not found exception
    @param filename (file should have name and weight divided with "="
*/


    //list of items loaded from file
    ArrayList<Item> itemsList = new ArrayList<>();

    //creating list of items to be loaded to a rocket
    void loadItems(String fileName) {
        File file = new File(fileName);

        try (Scanner scan = new Scanner(file)){
            itemsList.clear();
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                int equationIndex = line.indexOf('=');
                String itemName = line.substring(0,equationIndex);
                int itemWeight = Integer.parseInt(line.substring(equationIndex + 1));
                itemsList.add(new Item(itemName, itemWeight));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Unable to load file " + fileName);
            System.out.println("Exception: " + e.getMessage());
        }
    }

    // loading rockets with item list (ArrayList)
    ArrayList<Rocket> loadU1Rockets(Rocket rocket, ArrayList<Item> itemsList) {

        ArrayList<Rocket> rockets = new ArrayList<>();

        for (Item item : itemsList) {
            if (rocket.canCarry(item)) {
                rocket.carry(item);
            } else {

                rockets.add(new U1(rocket.cargoLoaded));
                rocket.cargoLoaded = 0;
                rocket.carry(item);
            }
        }
        rockets.add(new U1(rocket.cargoLoaded));
        return rockets;
    }

    // loading rockets with item list (ArrayList)
    ArrayList<Rocket> loadU2Rockets(Rocket rocket, ArrayList<Item> itemsList) {

        ArrayList<Rocket> rockets = new ArrayList<>();

        for (Item item : itemsList) {
            if (rocket.canCarry(item)) {
                rocket.carry(item);
            } else {

                rockets.add(new U2(rocket.cargoLoaded));
                rocket.cargoLoaded = 0;
                rocket.carry(item);
            }
        }
        rockets.add(new U2(rocket.cargoLoaded));
        return rockets;
    }

    int runSimulation(ArrayList<Rocket> rockets) {

        //System.out.println(rockets);

        int rocketsCount = 0;
        boolean launchResult;

        // biorę rakietę
        // dodaję jej koszt
        // sprawdzam czy może lecieć
            //jeśli tak to idę do następnej
            //jeśli nie to biorę ją jeszcze raz

        for (Rocket rocket : rockets) {
            launchResult = rocket.launch(rocket);
            rocketsCount++;
            if (!launchResult){
                launchResult = rocket.launch(rocket);
                rocketsCount++;
            }
        }
        System.out.println("Total rockets launched: " + rocketsCount + " (crashed: " + (rocketsCount - rockets.size()) + ")");
        int budget = rocketsCount * rockets.get(0).costInMillions * 100000;
        System.out.println("Budget: " + String.format("%,d",budget) + "$\n");
        return budget;
    }

    //runSimulation
    // weź listę rakiet i odpal na nich launch() i land()



}
