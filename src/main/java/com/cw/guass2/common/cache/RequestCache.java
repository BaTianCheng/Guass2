package com.cw.guass2.common.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.cw.guass2.dispatch.entity.RequestEntity;

/**
 * 请求缓存
 * @author wicks
 */
@Repository
@CacheConfig(cacheNames = "ResponseCache")
public class RequestCache {
    
    public static Logger logger = LoggerFactory.getLogger(RequestCache.class);
    
    @CachePut(key = "#requestEntity.getRequestId()")
    public RequestEntity save(RequestEntity requestEntity) {
        return requestEntity;
    }

    @CacheEvict(key = "#requestId")
    public void delete(String requestId) {
    }

    @Cacheable(key = "#requestId")
    public RequestEntity get(String requestId) {
        return null;
    }

}
