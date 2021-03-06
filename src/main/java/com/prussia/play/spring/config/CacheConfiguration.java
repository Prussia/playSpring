package com.prussia.play.spring.config;

import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

/**
 * http://docs.spring.io/spring/docs/current/spring-framework-reference/html/cache.html
 * spring-boot-sample-cache
 * https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples/spring-boot-sample-cache
 * 
 * @Cacheable triggers cache population
 * @CacheEvict triggers cache eviction
 * @CachePut updates the cache without interfering with the method execution
 * @Caching regroups multiple cache operations to be applied on a method
 * @CacheConfig shares some common cache-related settings at class-level
 * @author phu021
 *
 */
@Configuration
@EnableCaching // delete it if to be disable caching
public class CacheConfiguration extends CachingConfigurerSupport {

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
		cacheManagerFactoryBean.setConfigLocation(new ClassPathResource("ehcache.xml"));
		cacheManagerFactoryBean.setShared(true);
		return cacheManagerFactoryBean;
	}

}
