package kz.aitu.navigation.model;

public final class DistanceCalculator {

    private static final double EARTH_RADIUS_KM = 6371.0;

    private DistanceCalculator() {
    }

    public static double straightLineKm(Location from, Location to) {
        double latFrom = Math.toRadians(from.latitude());
        double latTo = Math.toRadians(to.latitude());
        double deltaLat = latTo - latFrom;
        double deltaLon = Math.toRadians(to.longitude() - from.longitude());

        double a = Math.sin(deltaLat / 2) * Math.sin(deltaLat / 2)
                + Math.cos(latFrom) * Math.cos(latTo)
                * Math.sin(deltaLon / 2) * Math.sin(deltaLon / 2);

        return EARTH_RADIUS_KM * 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
    }
}
