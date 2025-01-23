package helo.advanced;

import helo.advanced.trace.logTrace.FieldLogTrace;
import helo.advanced.trace.logTrace.LogTrace;
import helo.advanced.trace.logTrace.ThreadLocalLogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogTraceConfig {

    @Bean
    public LogTrace logTrace(){
        return new ThreadLocalLogTrace();
    }
}
