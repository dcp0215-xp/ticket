```properties
spring.datasource.url=jdbc:mysql://127.0.0.1:3306/ticket?useSSL=false&allowPublicKeyRetrieval=true
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.username=root
spring.datasource.password=123456

spring.redis.host=127.0.0.1
spring.redis.port=6379
spring.redis.database=0
spring.redis.lettuce.pool.max-active=8
spring.redis.lettuce.pool.max-wait=-1
spring.redis.lettuce.pool.max-idle=8
spring.redis.lettuce.pool.min-idle=0
spring.redis.sentinel.master=
spring.redis.sentinel.nodes=

spring.cache.type=redis
spring.cache.cache-name=ticketCache

mybatis-plus.mapper-locations=classpath:mapper/**/*.xml
mybatis-plus.type-aliases-package=com.dcp.ticket.**.model
mybatis-plus.configuration.cache-enabled=true

server.port=8080

```