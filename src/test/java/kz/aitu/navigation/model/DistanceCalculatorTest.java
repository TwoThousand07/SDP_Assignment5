package kz.aitu.navigation.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DistanceCalculatorTest {

    @Test
    void distanceBetweenSamePointIsZero() {
        Location point = new Location("Point", 51.1283, 71.4305);

        assertEquals(0.0, DistanceCalculator.straightLineKm(point, point), 0.0001);
    }

    @Test
    void distanceIsSymmetric() {
        Location a = new Location("A", 51.1283, 71.4305);
        Location b = new Location("B", 51.1328, 71.4036);

        assertEquals(DistanceCalculator.straightLineKm(a, b),
                DistanceCalculator.straightLineKm(b, a), 0.0001);
    }

    @Test
    void oneDegreeOfLatitudeIsAboutOneHundredElevenKilometers() {
        Location a = new Location("A", 0.0, 0.0);
        Location b = new Location("B", 1.0, 0.0);

        assertEquals(111.19, DistanceCalculator.straightLineKm(a, b), 0.1);
    }
}
