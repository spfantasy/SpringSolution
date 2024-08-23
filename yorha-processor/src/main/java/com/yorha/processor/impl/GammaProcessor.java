package com.yorha.processor.impl;

import com.yorha.processor.common.Processor;
import com.yorha.processor.entity.Context;

public class GammaProcessor implements Processor<GammaProcessorContext> {
    @Override
    public void process(GammaProcessorContext context) {
        context.setVersion("1");
    }
}
