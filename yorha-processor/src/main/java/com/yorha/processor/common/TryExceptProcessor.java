package com.yorha.processor.common;


import com.yorha.processor.entity.*;

import java.util.*;
import java.util.stream.*;

/**
 * 公共类
 * try并有分支的catch+执行多个Processor
 */
public final class TryExceptProcessor<C extends Context> implements Processor<C> {

    private final Processor<? super C> processor;
    private final Processor<? super C> exceptionProcessor;
    public TryExceptProcessor(
            String customName,
            Processor<? super C> processor,
            Processor<? super C> exceptionProcessor) {
        this.setCustomName(customName);
        this.processor = processor;
        this.exceptionProcessor = exceptionProcessor;
    }

    @Override
    public String getFullName() {
        return getName() + "\n\t" + Stream.of(this.exceptionProcessor)
                .map(Processor::getFullName)
                .map(s -> "[x]" + s)
                .map(s -> s.split("\n"))
                .flatMap(Arrays::stream)
                .collect(Collectors.joining("\n\t"));
    }

    @Override
    public String getCustomName() {
        return customName;
    }

    public void setCustomName(String customName) {
        this.customName = customName;
    }

    private String customName;

    @Override
    public void process(C context) {
        try {
            this.processor.process(context);
        } catch (Exception e) {
            this.exceptionProcessor.process(context);
        }
    }

}