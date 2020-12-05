package  com.gbques.ly.cloud.seataorderservice.service;


import com.gbques.ly.cloud.seataorderservice.domain.Order;

public interface OrderService {

    /**
     * 创建订单
     */
    void create(Order order);
}
