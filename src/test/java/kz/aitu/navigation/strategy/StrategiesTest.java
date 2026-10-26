package kz.aitu.navigation.strategy;

import kz.aitu.navigation.model.Location;
import kz.aitu.navigation.model.Route;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StrategiesTest {

    private final Location baiterek = new Location("Baiterek", 51.1283, 71.4305);
    private final Location khanShatyr = new Location("Khan Shatyr", 51.1328, 71.4036);

    @Test
    void carRouteHasCarMode() {
        Route route = new CarStrategy().buildRoute(baiterek, khanShatyr);

        assertEquals("Car", route.mode());
        assertEquals(3, route.steps().size());
    }

    @Test
    void walkingIsSlowerThanDriving() {
        Route car = new CarStrategy().buildRoute(baiterek, khanShatyr);
        Route walk = new WalkStrategy().buildRoute(baiterek, khanShatyr);

        assertTrue(walk.durationMinutes() > car.durationMinutes());
    }

    @Test
    void cyclingIsFasterThanWalking() {
        Route walk = new WalkStrategy().buildRoute(baiterek, khanShatyr);
        Route cycle = new CycleStrategy().buildRoute(baiterek, khanShatyr);

        assertTrue(cycle.durationMinutes() < walk.durationMinutes());
    }

    @Test
    void everyStrategyReturnsPositiveDistance() {
        RouteStrategy[] strategies = {new CarStrategy(), new WalkStrategy(), new CycleStrategy()};

        for (RouteStrategy strategy : strategies) {
            assertTrue(strategy.buildRoute(baiterek, khanShatyr).distanceKm() > 0);
        }
    }
}
