package helo.advanced.v2;

import helo.advanced.trace.HelloTraceV1;
import helo.advanced.trace.HelloTraceV2;
import helo.advanced.trace.TraceStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //@responseBody + @controller + component가 있어서 자동 bean 등록
@RequiredArgsConstructor
public class OrderControllerV2 {

    private final OrderServiceV2 orderService;
    private final HelloTraceV2 trace;

    @GetMapping("/v2/request")
    public String request(String itemId){

        TraceStatus status =  null;

        try {
            status = trace.begin("OrderController.request()");
            orderService.orderItem(status.getTraceId(), itemId);
            trace.end(status);
            return "ok";
        }  catch (Exception e){
            trace.exception(status, e);
            throw e;
        }

    }
}
