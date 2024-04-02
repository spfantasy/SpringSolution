package com.yorha.processor.impl;

import com.yorha.processor.common.Processor;
import com.yorha.processor.entity.Context;

/**
 * 业务类
 * 具体业务逻辑
 */

public class AlphaProcessor implements Processor<AlphaProcessorContext> {
    @Override
    public void process(AlphaProcessorContext context) {
        context.setId("123");
    }
}
