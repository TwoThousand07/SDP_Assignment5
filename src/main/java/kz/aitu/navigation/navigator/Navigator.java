package kz.aitu.navigation.navigator;

import kz.aitu.navigation.model.Location;
import kz.aitu.navigation.model.Route;
import kz.aitu.navigation.strategy.RouteStrategy;

import java.util.Objects;

public class Navigator {

    private RouteStrategy strategy;

    public Navigator(RouteStrategy strategy) {
        this.strategy = Objects.requireNonNull(strategy, "Strategy must not be null");
    }

    public void setStrategy(RouteStrategy strategy) {
        this.strategy = Objects.requireNonNull(strategy, "Strategy must not be null");
    }

    public Route planRoute(Location from, Location to) {
        return strategy.buildRoute(from, to);
    }

    public String currentStrategyName() {
        return strategy.getName();
    }
}
