package com.gbques.ly.cloud.sentinelservice.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.gbques.ly.cloud.sentinelservice.model.CommonResult;

/**
 * @author ly
 * @since 2020-12-04 16:01
 * 自定义限流处理逻辑
 */
public class CustomBlockHandler {

    public CommonResult handleException(BlockException exception){
        return new CommonResult("自定义限流信息",200);
    }
}