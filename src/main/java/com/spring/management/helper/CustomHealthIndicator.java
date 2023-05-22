package com.spring.management.helper;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class CustomHealthIndicator implements HealthIndicator {

    public boolean isHealthGood()
    {
        return true;
    }
    @Override
    public Health health() {
        if(isHealthGood())
            return Health.up().withDetail("1","Working good").build();
        else
            return Health.down().withDetail("1","Sever Down").build();
    }
}
