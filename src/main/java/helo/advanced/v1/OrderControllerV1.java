package helo.advanced.v1;

import helo.advanced.trace.HelloTraceV1;
import helo.advanced.trace.TraceStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //@responseBody + @controller + component가 있어서 자동 bean 등록
@RequiredArgsConstructor
public class OrderControllerV1 {

    private final OrderServiceV1 orderService;
    private final HelloTraceV1 trace;

    @GetMapping("/v1/request")
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
