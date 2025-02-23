package helo.proxy;

import helo.proxy.trace.logTrace.LogTrace;
import helo.proxy.trace.logTrace.ThreadLocalLogTrace;

import helo.proxy.config.v2_dynamicproxy.DynamicProxyBasicConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

/*
@Import({AppV1Config.class, AppV2Config.class, AppV3Config.class})
@SpringBootApplication(scanBasePackages = "helo.proxy.app") //주의
public class ProxyApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProxyApplication.class, args);
    }
}*/

//@Import(InterfaceProxyConfig.class)
@Import(DynamicProxyBasicConfig.class)
@SpringBootApplication(scanBasePackages = "helo.proxy.app")
public class ProxyApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProxyApplication.class, args);
    }
    @Bean
    public LogTrace logTrace() {
        return new ThreadLocalLogTrace();
    }
}