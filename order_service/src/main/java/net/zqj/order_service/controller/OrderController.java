package net.zqj.order_service.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import net.zqj.order_service.service.ProductOrderService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {
    @Autowired
    private ProductOrderService productOrderService;

    @Autowired
    private StringRedisTemplate redisTemplate;


    @RequestMapping("save")
    @HystrixCommand(fallbackMethod = "saveOrderFail")
    public Object save(@RequestParam("userId")int userId, @RequestParam("productId")int productId, HttpServletRequest request){

//        System.out.println("cookie:"+request.getHeader("cookie"));
//        System.out.println("token:"+request.getHeader("token"));



        Map<String,Object> data = new HashMap<String,Object>();
        data.put("code",0);
        data.put("data",productOrderService.save(userId,productId));

        return data;
    }

    private Object saveOrderFail(int userId,int productId,HttpServletRequest request){

        //监控报警
        String saveOrderKey = "save-order";
        String sendValue = redisTemplate.opsForValue().get(saveOrderKey);
        final String ip = request.getRemoteAddr();
        new Thread(()->{

            if(StringUtils.isBlank(sendValue)){
                System.out.println("紧急短信，系统故障主机是="+ip);
                //发送短信

                redisTemplate.opsForValue().set(saveOrderKey,"save-order-fail",20, TimeUnit.SECONDS);
            }else{
                System.out.println("已经发送过短信，10秒内不再发送");
            }
        }).start();

        Map<String,Object> msg = new HashMap<String,Object>();
        msg.put("code",-1);
        msg.put("msg","抢购人数太多！！！git   ！！！！");
        return msg;
    }

}
