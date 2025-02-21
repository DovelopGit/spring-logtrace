package helo.advanced.v5;

import helo.advanced.trace.callback.TraceCallback;
import helo.advanced.trace.logTrace.LogTrace;
import helo.advanced.trace.callback.TraceTemplate;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //@responseBody + @controller + component가 있어서 자동 bean 등록
public class OrderControllerV5 {

    private final OrderServiceV5 orderService;
    private final TraceTemplate template;
    public OrderControllerV5(OrderServiceV5 orderService, LogTrace trace) {
        this.orderService = orderService;
        this.template = new TraceTemplate(trace);
    }
    @GetMapping("/v5/request")
    public String request(String itemId) {
        return template.execute("OrderController.request()", new
                TraceCallback<>() {
                    @Override
                    public String call() {
                        orderService.orderItem(itemId);
                        return "ok";
                    }
                });
    }
}
