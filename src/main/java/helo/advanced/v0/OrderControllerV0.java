package helo.advanced.v0;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //@responseBody + @controller + component가 있어서 자동 bean 등록
@RequiredArgsConstructor
public class OrderControllerV0 {

    private final OrderServiceV0 orderService;

    @GetMapping("/v0/request")
    public String request(String itemId){
        orderService.orderItem(itemId);
        return "ok";
    }
}
