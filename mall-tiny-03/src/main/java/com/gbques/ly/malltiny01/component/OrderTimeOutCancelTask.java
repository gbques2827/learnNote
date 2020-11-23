package com.gbques.ly.malltiny01.component;

/**
 * @author ly
 * @since 2020-11-23 9:11
 * 订单超时取消并解锁库存的定时器
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class OrderTimeOutCancelTask {
    private Logger LOGGER = LoggerFactory.getLogger(OrderTimeOutCancelTask.class);

    /**
     * cron表达式：Seconds Minutes Hours DayofMonth Month DayofWeek [Year]
     * 每10分钟扫描一次，扫描设定超时时间之前下的订单，如果没支付则取消该订单
     */
    //https://www.pppet.net/ 该网站可以生成corn表达式
    //Cron表达式是一个字符串，包括6~7个时间元素
    //0 0/10 * ? * ? 6个
    //0/10 * * * * ? 6个
    //分别匹配：秒	分钟	小时	日	月 星期	年
    //0/10表示从0开始每10执行一次
    //@Scheduled(cron = "0 0/10 * ? * ?")
    @Scheduled(cron = "0/10 * * * * ?")
    private void cancelTimeOutOrder() {
        //测试
        System.out.println("=========================每10秒打印一次");
        // TODO: 2019/5/3 此处应调用取消订单的方法，具体查看mall项目源码
        LOGGER.info("取消订单，并根据sku编号释放锁定库存");
    }
}