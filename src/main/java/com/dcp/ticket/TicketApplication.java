package com.dcp.ticket;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * SpringBoot启动类
 *
 * @author dcp
 * @since 2020-08-11 19:25:01
 */
@SpringBootApplication
@MapperScan("com.dcp.ticket.**.mapper")
@EnableRedisHttpSession()
public class TicketApplication {

    public static void main(String[] args) {
        SpringApplication.run(TicketApplication.class, args);
    }

}
