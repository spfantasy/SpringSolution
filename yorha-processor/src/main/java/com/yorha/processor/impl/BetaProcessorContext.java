package com.yorha.processor.impl;

import com.yorha.processor.common.Processor;
import com.yorha.processor.entity.Context;

public interface BetaProcessorContext extends Context {
    String getId();

    void setInfo(String info);
}
