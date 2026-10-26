package kz.aitu.navigation;

import kz.aitu.navigation.model.Location;
import kz.aitu.navigation.navigator.Navigator;
import kz.aitu.navigation.strategy.CarStrategy;
import kz.aitu.navigation.strategy.CycleStrategy;
import kz.aitu.navigation.strategy.PublicTransportStrategy;
import kz.aitu.navigation.strategy.WalkStrategy;

public class Main {

    public static void main(String[] args) {
        Location baiterek = new Location("Baiterek", 51.1283, 71.4305);
        Location khanShatyr = new Location("Khan Shatyr", 51.1328, 71.4036);

        Navigator navigator = new Navigator(new CarStrategy());
        printRoute(navigator, baiterek, khanShatyr);

        navigator.setStrategy(new WalkStrategy());
        printRoute(navigator, baiterek, khanShatyr);

        navigator.setStrategy(new CycleStrategy());
        printRoute(navigator, baiterek, khanShatyr);

        navigator.setStrategy(new PublicTransportStrategy());
        printRoute(navigator, baiterek, khanShatyr);
    }

    private static void printRoute(Navigator navigator, Location from, Location to) {
        System.out.println("Current strategy: " + navigator.currentStrategyName());
        System.out.println(navigator.planRoute(from, to).describe());
    }
}
