package com.yorha.processor.common;


import com.yorha.processor.entity.*;

import java.util.*;
import java.util.stream.*;

/**
 * 公共类
 * 串行的执行多个Processor
 */
public final class CompositeProcessor<C extends Context> implements Processor<C> {

    private final List<Processor<? super C>> processors;

    @Override
    public String getCustomName() {
        return customName;
    }

    @Override
    public String getFullName() {
        return getName() + "\n\t" + this.processors.stream()
                .map(Processor::getFullName)
                .map(s -> s.split("\n"))
                .flatMap(Arrays::stream)
                .collect(Collectors.joining("\n\t"));
    }

    public void setCustomName(String customName) {
        this.customName = customName;
    }

    private String customName;

    public CompositeProcessor(String customName, Processor<? super C> processors1) {
        this.setCustomName(customName);
        this.processors = new ArrayList<>();
        this.processors.add(processors1);
    }

    public CompositeProcessor(String customName,
                              Processor<? super C> processors1,
                              Processor<? super C> processors2) {
        this.setCustomName(customName);
        this.processors = new ArrayList<>();
        this.processors.add(processors1);
        this.processors.add(processors2);
    }

    public CompositeProcessor(String customName,
                              Processor<? super C> processors1,
                              Processor<? super C> processors2,
                              Processor<? super C> processors3) {
        this.setCustomName(customName);
        this.processors = new ArrayList<>();
        this.processors.add(processors1);
        this.processors.add(processors2);
        this.processors.add(processors3);
    }

    public CompositeProcessor(String customName,
                              Processor<? super C> processors1,
                              Processor<? super C> processors2,
                              Processor<? super C> processors3,
                              Processor<? super C> processors4) {
        this.setCustomName(customName);
        this.processors = new ArrayList<>();
        this.processors.add(processors1);
        this.processors.add(processors2);
        this.processors.add(processors3);
        this.processors.add(processors4);
    }

    public CompositeProcessor(String customName,
                              Processor<? super C> processors1,
                              Processor<? super C> processors2,
                              Processor<? super C> processors3,
                              Processor<? super C> processors4,
                              Processor<? super C> processors5) {
        this.setCustomName(customName);
        this.processors = new ArrayList<>();
        this.processors.add(processors1);
        this.processors.add(processors2);
        this.processors.add(processors3);
        this.processors.add(processors4);
        this.processors.add(processors5);
    }

    @SafeVarargs
    public CompositeProcessor(String customName, Processor<? super C> ...processors) {
        this.setCustomName(customName);
        this.processors = new ArrayList<>();
        Collections.addAll(this.processors, processors);
    }

    @Override
    public void process(C context) {
        processors.forEach(cProcessor -> cProcessor.process(context));
    }

}