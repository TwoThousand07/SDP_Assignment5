package kz.aitu.navigation.strategy;

import kz.aitu.navigation.model.Location;
import kz.aitu.navigation.model.Route;
import kz.aitu.navigation.navigator.Navigator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PublicTransportStrategyTest {

    private final Location baiterek = new Location("Baiterek", 51.1283, 71.4305);
    private final Location khanShatyr = new Location("Khan Shatyr", 51.1328, 71.4036);

    @Test
    void routeIncludesWaitingTime() {
        Route bus = new PublicTransportStrategy().buildRoute(baiterek, khanShatyr);

        assertEquals("Public transport", bus.mode());
        assertTrue(bus.durationMinutes() >= 7);
    }

    @Test
    void worksWithNavigatorWithoutChangingIt() {
        Navigator navigator = new Navigator(new CarStrategy());

        navigator.setStrategy(new PublicTransportStrategy());

        assertEquals("Public transport", navigator.planRoute(baiterek, khanShatyr).mode());
    }
}
