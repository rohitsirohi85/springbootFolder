package com.codingshuttle.cachingApp.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;

@Configuration
@EnableCaching
public class CacheConfig {

           @Bean
         public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory){
               RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
                       .prefixCacheNameWith("My-redis-")  // the prefix name of cache
                       .entryTtl(Duration.ofSeconds(60))  // means the cache time to live
                       .enableTimeToIdle()       // cache ttl reset everytime when it is in used
                       .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer()))  // we want keys as a string serializer
                       .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer()));  // we want values as jackson from jason

               return RedisCacheManager.builder(redisConnectionFactory)
                       .cacheDefaults(redisCacheConfiguration)
                       .build();
           }
    }


