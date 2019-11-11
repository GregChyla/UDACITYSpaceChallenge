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

    void loadItems(String fileName) {
        File file = new File(fileName);

        try (Scanner scan = new Scanner(file)){
            itemsList.clear();
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                int equationmarkIndex = line.indexOf('=');
                String itemName = line.substring(0,equationmarkIndex);
                int itemWeight = Integer.parseInt(line.substring(equationmarkIndex + 1));
                itemsList.add(new Item(itemName, itemWeight));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Unable to load file " + fileName);
            System.out.println("Exception: " + e.getMessage());
        }
    }

    ArrayList<Rocket> loadRockets(Rocket rocket, ArrayList<Item> itemsList) {

        ArrayList<Rocket> rockets = new ArrayList<>();

        for (Item item : itemsList) {
            if (rocket.canCarry(item)) {
                rocket.carry(item);
            } else {
                rockets.add(new Rocket(rocket.cargoLoaded));
                rocket.cargoLoaded = 0;
                rocket.carry(item);
            }
        }
        rockets.add(new Rocket(rocket.cargoLoaded));
        return rockets;
    }



    //runSimulation
    // weź listę rakiet i odpal na nich launch() i land()



}
