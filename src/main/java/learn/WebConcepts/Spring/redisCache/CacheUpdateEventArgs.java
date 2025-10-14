package learn.WebConcepts.Spring.redisCache;

import org.springframework.context.ApplicationEvent;

import lombok.Getter;

@SuppressWarnings("serial")
@Getter
public class CacheUpdateEventArgs extends ApplicationEvent {
	
	private String cacheName;
	
	private String key;

	public CacheUpdateEventArgs(Object source, String cacheName, String key) {
		super(source);
		this.cacheName = cacheName;
		this.key = key;
	}
	
	
}
