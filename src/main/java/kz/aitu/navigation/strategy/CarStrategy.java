package kz.aitu.navigation.strategy;

import kz.aitu.navigation.model.DistanceCalculator;
import kz.aitu.navigation.model.Location;
import kz.aitu.navigation.model.Route;

import java.util.List;

public class CarStrategy implements RouteStrategy {

    private static final double ROAD_FACTOR = 1.3;
    private static final double AVERAGE_SPEED_KMH = 40.0;
    private static final int PARKING_MINUTES = 5;

    @Override
    public Route buildRoute(Location from, Location to) {
        double distanceKm = DistanceCalculator.straightLineKm(from, to) * ROAD_FACTOR;
        int minutes = (int) Math.ceil(distanceKm / AVERAGE_SPEED_KMH * 60) + PARKING_MINUTES;

        List<String> steps = List.of(
                "Get into the car at " + from.name(),
                "Follow the main roads to " + to.name(),
                "Find a parking place near " + to.name()
        );

        return new Route(getName(), from, to, distanceKm, minutes, steps);
    }

    @Override
    public String getName() {
        return "Car";
    }
}
