package com.prussia.test.play.spring.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching // delete it if to be disable caching
public class CacheConfiguration {

//	private final CacheManager cacheManager;
//
//	@Autowired
//	public CacheConfiguration() {
//		this.cacheManager = CacheManager.getInstance();
//	}
//
//	@PreDestroy
//	public void destroy() {
//		cacheManager.shutdown();
//	}

	/**
	 * TODO Not sure why there is no class EhCacheCacheManager in spring cache
	 * package
	 */

}
