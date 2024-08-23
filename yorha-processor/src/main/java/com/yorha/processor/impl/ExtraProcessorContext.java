package com.yorha.processor.impl;

import com.yorha.processor.common.Processor;
import com.yorha.processor.entity.Context;

public interface ExtraProcessorContext extends Context {
    void setExtra(String extra);
}
