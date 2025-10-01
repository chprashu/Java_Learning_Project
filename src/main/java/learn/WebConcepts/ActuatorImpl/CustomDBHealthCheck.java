package learn.WebConcepts.ActuatorImpl;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component("custom_database_Check")
public class CustomDBHealthCheck implements HealthIndicator {

    @Override
    public Health health() {
        Health health = Health.up().build();

        return health;
    }

}
