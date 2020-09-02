package com.dcp.ticket.base.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

import java.nio.charset.StandardCharsets;

/**
 * redis 配置类
 * @author dcp
 * @since 2020-08-12 22:00:00
 */
@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 36000)
public class LettuceRedisConfig extends CachingConfigurerSupport {

  /**
   * redis key生成器
   *
   * @return
   */
  @Bean
  @Override
  public KeyGenerator keyGenerator() {
    return (target, method, params) -> {
      StringBuilder keyBuilder = new StringBuilder();
      keyBuilder.append(target.getClass().getName()).append(method.getName());
      for (Object param: params) {
          keyBuilder.append(param.toString());
      }
      return keyBuilder.toString();
    };
  }

  /**
   * 设置redisTemplate序列化方式
   *
   * @param connectionFactory
   * @return
   */
  @Bean
  public RedisOperations<Object, Object> redisTemplate(LettuceConnectionFactory connectionFactory) {
    RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();
    redisTemplate.setKeySerializer(new StringRedisSerializer());
    redisTemplate.setHashKeySerializer(new StringRedisSerializer());
    redisTemplate.setValueSerializer(new FastJsonRedisSerializer<>(Object.class));
    redisTemplate.setHashValueSerializer(new FastJsonRedisSerializer<>(Object.class));
    redisTemplate.setConnectionFactory(connectionFactory);
    redisTemplate.setDefaultSerializer(new FastJsonRedisSerializer<>(Object.class));
    return redisTemplate;
  }



  /**
   * Redis Value序列化
   * @param <T>
   */
  class FastJsonRedisSerializer<T> implements RedisSerializer<T> {

    private Class<T> clazz;

    public FastJsonRedisSerializer(Class<T> clazz) {
      super();
      this.clazz = clazz;
    }

    @Override
    public byte[] serialize(T t) throws SerializationException {
      if (t == null) {
        return new byte[0];
      }
      return JSON.toJSONString(t, SerializerFeature.WriteClassName).getBytes(StandardCharsets.UTF_8);
    }

    @Override
    public T deserialize(byte[] bytes) throws SerializationException {
      if (bytes == null || bytes.length <= 0) {
        return null;
      }
      String str = new String(bytes, StandardCharsets.UTF_8);
      return JSON.parseObject(str, clazz);
    }
  }
}
