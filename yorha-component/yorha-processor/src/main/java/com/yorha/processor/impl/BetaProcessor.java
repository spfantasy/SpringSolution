package com.yorha.processor.impl;

import com.yorha.processor.common.Processor;
import com.yorha.processor.entity.Context;

public class BetaProcessor implements Processor<BetaProcessorContext> {
    @Override
    public void process(BetaProcessorContext context) {
        context.setInfo(context.getId()+"Beta");
    }
}
