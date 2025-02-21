package helo.proxy;

import helo.advanced.trace.logTrace.LogTrace;
import helo.advanced.trace.logTrace.ThreadLocalLogTrace;
import helo.proxy.config.AppV1Config;
import helo.proxy.config.AppV2Config;
import helo.proxy.config.AppV3Config;
import helo.proxy.config.v1_proxy.InterfaceProxyConfig;
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

@Import(InterfaceProxyConfig.class)
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