package kz.aitu.navigation.navigator;

import kz.aitu.navigation.model.Location;
import kz.aitu.navigation.model.Route;
import kz.aitu.navigation.strategy.CarStrategy;
import kz.aitu.navigation.strategy.WalkStrategy;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class NavigatorTest {

    private final Location from = new Location("Baiterek", 51.1283, 71.4305);
    private final Location to = new Location("Khan Shatyr", 51.1328, 71.4036);

    @Test
    void navigatorDelegatesToCurrentStrategy() {
        Navigator navigator = new Navigator(new CarStrategy());

        Route route = navigator.planRoute(from, to);

        assertEquals("Car", route.mode());
    }

    @Test
    void strategyCanBeSwitchedAtRuntime() {
        Navigator navigator = new Navigator(new CarStrategy());
        Route carRoute = navigator.planRoute(from, to);

        navigator.setStrategy(new WalkStrategy());
        Route walkRoute = navigator.planRoute(from, to);

        assertEquals("Walk", navigator.currentStrategyName());
        assertNotEquals(carRoute.mode(), walkRoute.mode());
    }

    @Test
    void customStrategyCanBePluggedIn() {
        Navigator navigator = new Navigator(new CarStrategy());

        navigator.setStrategy(new kz.aitu.navigation.strategy.RouteStrategy() {
            @Override
            public Route buildRoute(Location start, Location end) {
                return new Route("Test", start, end, 1.0, 1, List.of("Go"));
            }

            @Override
            public String getName() {
                return "Test";
            }
        });

        assertEquals("Test", navigator.planRoute(from, to).mode());
    }

    @Test
    void nullStrategyIsRejected() {
        Navigator navigator = new Navigator(new CarStrategy());

        assertThrows(NullPointerException.class, () -> navigator.setStrategy(null));
        assertThrows(NullPointerException.class, () -> new Navigator(null));
    }
}
