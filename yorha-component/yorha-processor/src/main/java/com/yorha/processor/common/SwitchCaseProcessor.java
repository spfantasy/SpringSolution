package com.yorha.processor.common;


import com.yorha.processor.entity.*;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

/**
 * 公共类
 * 有分支的执行多个Processor
 */
public final class SwitchCaseProcessor<C extends Context> implements Processor<C> {

    private final List<AbstractMap.SimpleImmutableEntry<Function<? super C, Boolean>, Processor<? super C>>> processorSwitcher;
    public SwitchCaseProcessor(
            String customName,
            Processor<? super C> processor1,Function<? super C, Boolean> condition1,
            Processor<? super C> processor2,Function<? super C, Boolean> condition2) {
        this.setCustomName(customName);
        this.processorSwitcher = new ArrayList<>();
        this.processorSwitcher.add(new AbstractMap.SimpleImmutableEntry<>(condition1, processor1));
        this.processorSwitcher.add(new AbstractMap.SimpleImmutableEntry<>(condition2, processor2));
    }

    @Override
    public String getFullName() {
        return getName() + "\n\t" + this.processorSwitcher.stream()
                .map(AbstractMap.SimpleImmutableEntry::getValue)
                .map(Processor::getFullName)
                .map(s -> "[?]" + s)
                .map(s -> s.split("\n"))
                .flatMap(Arrays::stream)
                .collect(Collectors.joining("\n\t"));
    }

    public SwitchCaseProcessor(
            String customName,
            Processor<? super C> processor1,Function<? super C, Boolean> condition1,
            Processor<? super C> processor2,Function<? super C, Boolean> condition2,
            Processor<? super C> processor3,Function<? super C, Boolean> condition3) {
        this.setCustomName(customName);
        this.processorSwitcher = new ArrayList<>();
        this.processorSwitcher.add(new AbstractMap.SimpleImmutableEntry<>(condition1, processor1));
        this.processorSwitcher.add(new AbstractMap.SimpleImmutableEntry<>(condition2, processor2));
        this.processorSwitcher.add(new AbstractMap.SimpleImmutableEntry<>(condition3, processor3));
    }

    public SwitchCaseProcessor(
            String customName,
            Processor<? super C> processor1,Function<? super C, Boolean> condition1,
            Processor<? super C> processor2,Function<? super C, Boolean> condition2,
            Processor<? super C> processor3,Function<? super C, Boolean> condition3,
            Processor<? super C> processor4,Function<? super C, Boolean> condition4) {
        this.setCustomName(customName);
        this.processorSwitcher = new ArrayList<>();
        this.processorSwitcher.add(new AbstractMap.SimpleImmutableEntry<>(condition1, processor1));
        this.processorSwitcher.add(new AbstractMap.SimpleImmutableEntry<>(condition2, processor2));
        this.processorSwitcher.add(new AbstractMap.SimpleImmutableEntry<>(condition3, processor3));
        this.processorSwitcher.add(new AbstractMap.SimpleImmutableEntry<>(condition4, processor4));
    }

    public SwitchCaseProcessor(
            String customName,
            Processor<? super C> processor1,Function<? super C, Boolean> condition1,
            Processor<? super C> processor2,Function<? super C, Boolean> condition2,
            Processor<? super C> processor3,Function<? super C, Boolean> condition3,
            Processor<? super C> processor4,Function<? super C, Boolean> condition4,
            Processor<? super C> processor5,Function<? super C, Boolean> condition5) {
        this.setCustomName(customName);
        this.processorSwitcher = new ArrayList<>();
        this.processorSwitcher.add(new AbstractMap.SimpleImmutableEntry<>(condition1, processor1));
        this.processorSwitcher.add(new AbstractMap.SimpleImmutableEntry<>(condition2, processor2));
        this.processorSwitcher.add(new AbstractMap.SimpleImmutableEntry<>(condition3, processor3));
        this.processorSwitcher.add(new AbstractMap.SimpleImmutableEntry<>(condition4, processor4));
        this.processorSwitcher.add(new AbstractMap.SimpleImmutableEntry<>(condition5, processor5));
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
        for (AbstractMap.SimpleImmutableEntry<Function<? super C, Boolean>, Processor<? super C>> pair : this.processorSwitcher) {
            if (pair.getKey().apply(context)) {
                pair.getValue().process(context);
                break;
            }
        }
    }

}