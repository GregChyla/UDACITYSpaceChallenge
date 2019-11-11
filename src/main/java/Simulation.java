import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class Simulation {

    String phase1FileName = "src/phase-1.txt";
    String phase2FileName = "src/phase2.txt";

    int u1List = 1;
    int u2List = 1;

/*
    Filling up Array List of items from a file
    @exception: File not found exception
    @param filename (file should have name and weight divided with "="
*/


    //list of items loaded from file
    ArrayList<Item> itemsList = new ArrayList<>();


    void loadItems(String fileName) {
        try {
            File file = new File(fileName);
            Scanner scan = new Scanner(file);
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




    // loadU1 - weż listę itemów zwróconą przez loadItems i załaduj ją na U1
    // jeśli item nie mieści się do rakiety stwórz nową
    // zwróć ArrayListę załadowanych rakiet


//    void loadU1(ArrayList itemsList) {
//
//    }

    ArrayList<Rocket> loadRockets(Rocket rocket, ArrayList<Item> itemsList) {

        ArrayList<Rocket> rockets = new ArrayList<>();

        for (Item item : itemsList) {
            if (rocket.canCarry(item)) {

//                System.out.println("Cargo loaded: " + rocket.cargoLoaded);
//                System.out.println("Space left: " + (rocket.maxWeightWithCargo - rocket.weight - rocket.cargoLoaded));
//                System.out.println("Item: " + item.name+ " " + item.weight);
//                System.out.println("Numer of rockets: " + u1List);
//                System.out.println();

                rocket.carry(item);
            } else {

                rockets.add(new Rocket(rocket.cargoLoaded));
                u1List++;
//                System.out.println("NEW ROCKET!--------------------------");
//                System.out.println("Cargo loaded: " + rocket.cargoLoaded);
//                System.out.println("Space left: " + (rocket.maxWeightWithCargo - rocket.weight - rocket.cargoLoaded));
//                System.out.println("Item: " + item.name+ " " + item.weight);
//                System.out.println("Numer of rockets: " + u1List);
//                System.out.println();
                rocket.cargoLoaded = 0;
                rocket.carry(item);
            }
        }
        rockets.add(new Rocket(rocket.cargoLoaded));

        return rockets;
        // uruchamiam metodę

    }


    //loadU2


//    void loadU2(ArrayList itemsList) {
//
//
//    }



    //runSimulation
    // weź listę rakiet i odpal na nich launch() i land()



}
