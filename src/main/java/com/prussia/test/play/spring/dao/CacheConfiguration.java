package com.prussia.test.play.spring.dao;

import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

import net.sf.ehcache.CacheManager;

@Configuration
@EnableCaching
public class CacheConfiguration {

	private final CacheManager cacheManager;

	@Autowired
	public CacheConfiguration() {
		this.cacheManager = CacheManager.getInstance();
	}

	@PreDestroy
	public void destroy() {
		cacheManager.shutdown();
	}

	/**
	 * TODO Not sure why there is no class EhCacheCacheManager in spring cache
	 * package
	 */

}
