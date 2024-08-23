package com.yorha.processor.impl;

import com.yorha.processor.common.Processor;
import com.yorha.processor.entity.Context;

/**
 * 业务类
 * 流程Alpha需要读写的所有字段，屏蔽了整个业务线上的其他读写字段
 */

public interface AlphaProcessorContext extends Context {
     void setId(String id);

}
