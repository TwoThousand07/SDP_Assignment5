package kz.aitu.navigation.strategy;

import kz.aitu.navigation.model.DistanceCalculator;
import kz.aitu.navigation.model.Location;
import kz.aitu.navigation.model.Route;

import java.util.List;

public class PublicTransportStrategy implements RouteStrategy {

    private static final double LINE_FACTOR = 1.4;
    private static final double AVERAGE_SPEED_KMH = 25.0;
    private static final int WAITING_MINUTES = 7;

    @Override
    public Route buildRoute(Location from, Location to) {
        double distanceKm = DistanceCalculator.straightLineKm(from, to) * LINE_FACTOR;
        int minutes = (int) Math.ceil(distanceKm / AVERAGE_SPEED_KMH * 60) + WAITING_MINUTES;

        List<String> steps = List.of(
                "Walk to the nearest bus stop from " + from.name(),
                "Take the bus towards " + to.name(),
                "Get off at the stop closest to " + to.name()
        );

        return new Route(getName(), from, to, distanceKm, minutes, steps);
    }

    @Override
    public String getName() {
        return "Public transport";
    }
}
