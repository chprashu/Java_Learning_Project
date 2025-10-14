package learn.configurations.commonBeans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
@EnableCaching
public class RedisConfig {
	
	@Value("${spring.data.redis.host}")
	private String host;
	
	@Value("${spring.data.redis.port}")
	private int port;
	
	/*
	 * RedisConnectionFactory is needed to get to know 
	 * in which server cache is saving 
	 * getting host, port will give the flexibility to
	 * know where redis is running based on the configurations.
	 */
	@Bean
	public RedisConnectionFactory connectionFactory() {
		RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration(host, port);
		return new JedisConnectionFactory(configuration);
	}
	
	
	/*
	 * this bean helps redis to serialize and desirialize the keys and values of cache
	 */
	@Bean
	public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory connectionFactory){
		RedisTemplate<String, Object> template = new RedisTemplate<>();
		template.setConnectionFactory(connectionFactory);
		
		// to serialize key since we only get Strings
		template.setKeySerializer(new StringRedisSerializer());
		// to serialize value, we may get JSON objects
		template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
		
		//hash serialization for key and values
		template.setHashKeySerializer(new StringRedisSerializer());
		template.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());
		
		template.afterPropertiesSet();
		return template;
		
	}
}
