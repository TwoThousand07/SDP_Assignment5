package kz.aitu.navigation.model;

import java.util.List;

public record Route(String mode,
                    Location from,
                    Location to,
                    double distanceKm,
                    int durationMinutes,
                    List<String> steps) {

    public String describe() {
        StringBuilder text = new StringBuilder();
        text.append(String.format("Mode: %s%n", mode));
        text.append(String.format("Route: %s -> %s%n", from.name(), to.name()));
        text.append(String.format("Distance: %.2f km%n", distanceKm));
        text.append(String.format("Time: %d min%n", durationMinutes));
        for (int i = 0; i < steps.size(); i++) {
            text.append(String.format("  %d. %s%n", i + 1, steps.get(i)));
        }
        return text.toString();
    }
}
