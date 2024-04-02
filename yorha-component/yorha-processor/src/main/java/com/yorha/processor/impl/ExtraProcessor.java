package com.yorha.processor.impl;

import com.yorha.processor.common.Processor;
import com.yorha.processor.entity.Context;

public class ExtraProcessor implements Processor<ExtraProcessorContext> {
    @Override
    public void process(ExtraProcessorContext context) {
        context.setExtra("extra");
    }
}
