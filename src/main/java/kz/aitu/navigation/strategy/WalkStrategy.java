package kz.aitu.navigation.strategy;

import kz.aitu.navigation.model.DistanceCalculator;
import kz.aitu.navigation.model.Location;
import kz.aitu.navigation.model.Route;

import java.util.List;

public class WalkStrategy implements RouteStrategy {

    private static final double PATH_FACTOR = 1.2;
    private static final double AVERAGE_SPEED_KMH = 5.0;

    @Override
    public Route buildRoute(Location from, Location to) {
        double distanceKm = DistanceCalculator.straightLineKm(from, to) * PATH_FACTOR;
        int minutes = (int) Math.ceil(distanceKm / AVERAGE_SPEED_KMH * 60);

        List<String> steps = List.of(
                "Leave " + from.name() + " on foot",
                "Use sidewalks and pedestrian crossings towards " + to.name(),
                "Arrive at " + to.name()
        );

        return new Route(getName(), from, to, distanceKm, minutes, steps);
    }

    @Override
    public String getName() {
        return "Walk";
    }
}
