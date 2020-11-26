package com.gbques.ly.malltiny01.service;

/**
 * @author ly
 * @since 2020-11-24 22:01
 */

import com.gbques.ly.malltiny01.common.CommonResult;
import com.gbques.ly.malltiny01.dto.OrderParam;
import org.springframework.transaction.annotation.Transactional;

/**
 * 前台订单管理Service
 * Created by macro on 2018/8/30.
 */
public interface OmsPortalOrderService {

    /**
     * 根据提交信息生成订单
     */
    @Transactional
    CommonResult generateOrder(OrderParam orderParam);

    /**
     * 取消单个超时订单
     */
    @Transactional
    void cancelOrder(Long orderId);
}