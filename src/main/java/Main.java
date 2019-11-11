import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Simulation simulation = new Simulation();
        simulation.loadItems(simulation.phase1FileName);
//        System.out.println(simulation.itemsList);
        ArrayList<Rocket> u1LoadedList = simulation.loadRockets(new U1(), simulation.itemsList);
//        System.out.println(u1LoadedList);

        for (Rocket rocket : u1LoadedList) {
            System.out.println(rocket.cargoLoaded);
        }
    }
}
