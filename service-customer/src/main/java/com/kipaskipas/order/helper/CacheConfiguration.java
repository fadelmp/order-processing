package com.kipaskipas.order.helper;

import org.springframework.cache.Cache;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.Nullable;

@EnableCaching
@Configuration
public class CacheConfiguration extends CachingConfigurerSupport {

  @Override
  public CacheErrorHandler errorHandler() {

    return new CacheErrorHandler() {

      @Override
      public void handleCacheGetError(RuntimeException exception, Cache cache, Object key) {

        System.out.println("Failure getting from cache: " + cache.getName());
      }

      @Override
      public void handleCachePutError(RuntimeException exception, Cache cache, Object key, @Nullable Object value) {

        System.out.println("Failure putting into cache: " + cache.getName());
      }

      @Override
      public void handleCacheEvictError(RuntimeException exception, Cache cache, Object key) {

        System.out.println("Failure evicting from cache: " + cache.getName());
      }

      @Override
      public void handleCacheClearError(RuntimeException exception, Cache cache) {

        System.out.println("Failure clearing cache: " + cache.getName());
      }
    };
  }

}