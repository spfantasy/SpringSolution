package com.yorha.processor.entity;

import com.yorha.processor.impl.*;

/**
 * 业务类
 * 某个业务流程的上下文，包含需要读写的所有变量需要实现整个流程中涉及Processor的所有接口
 */

public class MyContextEntity implements Context,
        AlphaProcessorContext,
        BetaProcessorContext,
        ExtraProcessorContext,
        GammaProcessorContext,
        SwitcherContext {
    private String id;
    private String version;
    private String info;

    private String extra;

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
