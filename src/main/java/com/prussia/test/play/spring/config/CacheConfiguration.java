package com.prussia.test.play.spring.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
@EnableCaching // delete it if to be disable caching
public class CacheConfiguration {

	// private final CacheManager cacheManager;
	//
	// @Autowired
	// public CacheConfiguration() {
	// this.cacheManager = CacheManager.getInstance();
	// }
	//
	// @PreDestroy
	// public void destroy() {
	// cacheManager.shutdown();
	// }

	/**
	 * TODO Not sure why there is no class EhCacheCacheManager in spring cache
	 * package
	 */

	/*
	 * ehcache 主要的管理器
	 */
	@Bean(name = "appEhCacheCacheManager")
	public EhCacheCacheManager ehCacheCacheManager(EhCacheManagerFactoryBean bean) {
		return new EhCacheCacheManager(bean.getObject());
	}

	/*
	 * 据shared与否的设置,Spring分别通过CacheManager.create()或new
	 * CacheManager()方式来创建一个ehcache基地.
	 */
	@Bean
	public EhCacheManagerFactoryBean ehCacheManagerFactoryBean() {
		EhCacheManagerFactoryBean cacheManagerFactoryBean = new EhCacheManagerFactoryBean();
		cacheManagerFactoryBean.setConfigLocation(new ClassPathResource("conf/ehcache-app.xml"));
		cacheManagerFactoryBean.setShared(true);
		return cacheManagerFactoryBean;
	}

}
