package learn.WebConcepts.Spring.redisCache;

import org.springframework.context.ApplicationEvent;

import lombok.Getter;

@SuppressWarnings("serial")
@Getter
public class CacheEvictEventArgs extends ApplicationEvent {

	private String cacheName;

	private String key;

	private boolean isSpclKey;

	public CacheEvictEventArgs(Object source, String cacheName, String key, boolean isSpclKey) {
		super(source);
		this.cacheName = cacheName;
		this.key = key;
		this.isSpclKey = isSpclKey;
	}

}
