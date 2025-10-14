package learn.WebConcepts.Spring.redisCache;

import org.apache.catalina.core.ApplicationPushBuilder;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@AllArgsConstructor
@Slf4j
public class CacheEvictEventListener {
	
	private final CacheManager cacheManager;
	private final ApplicationEventPublisher publisher;
	
	
	@SuppressWarnings("null")
	@EventListener
	public void handleCacheEvictEvent(CacheEvictEventArgs args) {
		String cacheName = args.getCacheName();
		String key = args.getKey();
		
		Cache cache = cacheManager.getCache(cacheName);
		
		StringBuilder builder = new StringBuilder("Evicting cache, cacheName: "+cacheName);
		if(args.isSpclKey()) {
			cache.clear();
		}else {
			cache.evict(key);
			builder.append(" and key: "+key);
		}
		
		publisher.publishEvent(new CacheUpdateEventArgs(this, cacheName, key));
	}
	
	
}
