package learn.WebConcepts.Spring.redisCache;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

import learn.configurations.Security.UserDetailsServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;


/*
 * Info about InitializingBean
 */
@Component
@AllArgsConstructor
@Slf4j
public class CacheUpdateRegistry implements InitializingBean {

    private final ListableBeanFactory factory;
    private final Map<String, Method> methodRegistry = new HashMap<>();
    private final Map<String, Object> beanRegistry = new HashMap<>();

    @Override
    public void afterPropertiesSet() throws Exception {
    	Map<String, Object> beansOfType = factory.getBeansWithAnnotation(Component.class);
    	
    	for(Object bean: beansOfType.values()) {
    		
    		for(Method method: bean.getClass().getDeclaredMethods()) {
    			if(bean instanceof UserDetailsServiceImpl && "getAllUsers".equals(method.getName())) {
    				System.out.println(Arrays.toString(method.getAnnotations()));
    				log.info("checking UserDetailsServiceImpl");
    				log.info("got method name");
    			}
    			
    			CacheUpdateListener annotation = AnnotationUtils.findAnnotation(method, CacheUpdateListener.class);
    			
    			if(annotation != null) {
    				String cacheKey = annotation.cacheName()+"::"+annotation.key();
    				methodRegistry.put(cacheKey, method);
    				beanRegistry.put(cacheKey, bean);
    			}
    		}
    	}
    }
    
    public void invoke(String cacheName, String key) {
    	String cacheKey = cacheName+"::"+key;
    	Method method = methodRegistry.get(cacheKey);
    	Object bean = beanRegistry.get(cacheKey);
    	
    	if(method != null && bean != null) {
    		try {
				method.setAccessible(true);
				method.invoke(bean);
			} catch (Exception e) {
				log.error(e.getMessage());
			}
    	}else {
    		log.error("no method registerd for this cache: "+cacheKey);
    	}
    }

}
