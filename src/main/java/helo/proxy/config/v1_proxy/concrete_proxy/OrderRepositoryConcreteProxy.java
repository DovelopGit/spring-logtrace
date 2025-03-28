package helo.proxy.config.v1_proxy.concrete_proxy;

import helo.advanced.trace.TraceStatus;
import helo.advanced.trace.logTrace.LogTrace;
import helo.proxy.app.v2.OrderRepositoryV2;

public class OrderRepositoryConcreteProxy extends OrderRepositoryV2 {
    private final OrderRepositoryV2 target;
    private final LogTrace logTrace;
    public OrderRepositoryConcreteProxy(OrderRepositoryV2 target, LogTrace
            logTrace) {
        this.target = target;
        this.logTrace = logTrace;
    }
    @Override
    public void save(String itemId) {
        TraceStatus status = null;
        try {
            status = logTrace.begin("OrderRepository.save()");
            //target 호출
            target.save(itemId);
            logTrace.end(status);
        } catch (Exception e) {
            logTrace.exception(status, e);
            throw e;
        }
    }
}
