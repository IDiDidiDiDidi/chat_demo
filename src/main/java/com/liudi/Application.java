package com.liudi;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
@MapperScan("com.liudi.mapper")
@EnableAsync
@EnableScheduling
@EnableSwagger2
public class Application {

    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);
    public static void main(String[] args) throws UnknownHostException {
        ConfigurableApplicationContext application= SpringApplication.run(Application.class, args);
        Environment env = application.getEnvironment();
        LOGGER.info("\n[----------------------------------------------------------]\n\t" +
                        "聊天室启动成功！点击进入:\thttp://{}:{}" +
                        "\n[----------------------------------------------------------",
                InetAddress.getLocalHost().getHostAddress(),
                env.getProperty("server.port"));
    }
}
