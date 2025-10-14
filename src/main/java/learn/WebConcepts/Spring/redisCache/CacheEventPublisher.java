package learn.WebConcepts.Spring.redisCache;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class CacheEventPublisher {
	
	private final ApplicationEventPublisher publisher;
	
	public void publishEvent(String cacheName, String key, boolean isSpclKey) {
		publisher.publishEvent(new CacheEvictEventArgs(this, cacheName, key, isSpclKey));
	}
}
