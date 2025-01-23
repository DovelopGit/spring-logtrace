package helo.advanced.v3;

import helo.advanced.trace.HelloTraceV2;
import helo.advanced.trace.TraceStatus;
import helo.advanced.trace.logTrace.LogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //@responseBody + @controller + component가 있어서 자동 bean 등록
@RequiredArgsConstructor
public class OrderControllerV3 {

    private final OrderServiceV3 orderService;
    private final LogTrace trace;

    @GetMapping("/v3/request")
    public String request(String itemId){

        TraceStatus status =  null;

        try {
            status = trace.begin("OrderController.request()");
            orderService.orderItem(itemId);
            trace.end(status);
            return "ok";
        }  catch (Exception e){
            trace.exception(status, e);
            throw e;
        }

    }
}
