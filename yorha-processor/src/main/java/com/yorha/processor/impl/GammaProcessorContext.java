package com.yorha.processor.impl;

import com.yorha.processor.common.Processor;
import com.yorha.processor.entity.Context;

public interface GammaProcessorContext extends Context {
    void setVersion(String version);
}
