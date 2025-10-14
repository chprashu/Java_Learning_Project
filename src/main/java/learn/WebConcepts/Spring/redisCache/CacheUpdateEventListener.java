package learn.WebConcepts.Spring.redisCache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class CacheUpdateEventListener {
	
	private CacheUpdateRegistry registry;
	
	@Autowired
	public void setRegistry(CacheUpdateRegistry registry) {
		this.registry = registry;
	}
	
	@EventListener
	public void handleCacheUpdateEvent(CacheUpdateEventArgs args) {
		registry.invoke(args.getCacheName(), args.getKey());
	}
}
