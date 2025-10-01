package learn.WebConcepts.ActuatorImpl;

import java.io.File;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component("custom_disk_space")
public class CustomDiskSpaceHealthCheck implements HealthIndicator {

    private final long threshold = 50 * 1024 * 1024; // 50 MB

    @Override
    public Health health() {
        File file = new File("/");
        long freeSpace = file.getFreeSpace();
        if (freeSpace < threshold) {
            return Health.down().withDetail("System already took more space, than the threshold..", freeSpace).build();
        }
        return Health.up().withDetail("Checking health actuator", freeSpace).build();
    }

}