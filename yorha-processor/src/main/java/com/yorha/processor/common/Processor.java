package com.yorha.processor.common;

import com.yorha.processor.entity.*;

/**
 * 公共类
 * Processor的基类
 */
@FunctionalInterface
public interface Processor<C extends Context> {
    void process(C context);

    /**
     * 当前Processor
     * @return
     */
    default String getName() {
        return getCustomName() == null ? getClass().getSimpleName() : getCustomName();
    }

    /**
     * 当前Processor及子Processor的结构图
     * @return
     */
    default String getFullName() {
        return getName();
    }

    default String getCustomName() {
        return null;
    }

}
