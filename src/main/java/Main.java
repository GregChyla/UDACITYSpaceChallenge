import java.util.ArrayList;



public class Main {

    static void printLoadedList(ArrayList<Rocket> rocketArrayList) {
        int iter = 1;
        for (Rocket rocket : rocketArrayList) {
            System.out.print("Rocket " + iter + ", cargo weight: ");
            System.out.println(rocket.cargoLoaded);
            iter++;
        }
    }

    public static void main(String[] args) {

        String phase1FileName = "src/phase-1.txt";
        String phase2FileName = "src/phase-2.txt";

        Simulation simulation = new Simulation();
        simulation.loadItems(phase1FileName);
        ArrayList<Rocket> u1LoadedList = simulation.loadRockets(new U1(), simulation.itemsList);

        System.out.println("Loading U1 rockets with Phase 1 items");
        System.out.println("-------------------------------------");
        printLoadedList(u1LoadedList);
        System.out.println();

        System.out.println("Loading U2 rockets with Phase 1 items");
        System.out.println("-------------------------------------");
        simulation.loadItems(phase1FileName);
        ArrayList<Rocket> u2LoadedList = simulation.loadRockets(new U2(), simulation.itemsList);
        printLoadedList(u2LoadedList);

        System.out.println();

        System.out.println("Loading U1 rockets with Phase 2 items");
        System.out.println("-------------------------------------");
        simulation.loadItems(phase2FileName);
        u1LoadedList = simulation.loadRockets(new U1(), simulation.itemsList);
        printLoadedList(u1LoadedList);
        System.out.println();

        System.out.println("Loading U2 rockets with Phase 2 items");
        System.out.println("-------------------------------------");
        simulation.loadItems(phase2FileName);
        u2LoadedList = simulation.loadRockets(new U2(), simulation.itemsList);
        printLoadedList(u2LoadedList);
        }
    }


