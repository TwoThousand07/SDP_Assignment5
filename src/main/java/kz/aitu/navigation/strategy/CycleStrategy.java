package kz.aitu.navigation.strategy;

import kz.aitu.navigation.model.DistanceCalculator;
import kz.aitu.navigation.model.Location;
import kz.aitu.navigation.model.Route;

import java.util.List;

public class CycleStrategy implements RouteStrategy {

    private static final double BIKE_LANE_FACTOR = 1.25;
    private static final double AVERAGE_SPEED_KMH = 15.0;

    @Override
    public Route buildRoute(Location from, Location to) {
        double distanceKm = DistanceCalculator.straightLineKm(from, to) * BIKE_LANE_FACTOR;
        int minutes = (int) Math.ceil(distanceKm / AVERAGE_SPEED_KMH * 60);

        List<String> steps = List.of(
                "Take your bike at " + from.name(),
                "Ride along bike lanes towards " + to.name(),
                "Lock the bike at " + to.name()
        );

        return new Route(getName(), from, to, distanceKm, minutes, steps);
    }

    @Override
    public String getName() {
        return "Bicycle";
    }
}
