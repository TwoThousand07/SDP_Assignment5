package kz.aitu.navigation.strategy;

import kz.aitu.navigation.model.Location;
import kz.aitu.navigation.model.Route;

public interface RouteStrategy {

    Route buildRoute(Location from, Location to);

    String getName();
}
