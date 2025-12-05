package com.bing.queen.ai.common.core.domain.dto;

import java.util.List;

public class AiRequestDTO {
    private String model;
    private List<AiContentDTO> contents;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<AiContentDTO> getContents() {
        return contents;
    }

    public void setContents(List<AiContentDTO> contents) {
        this.contents = contents;
    }
    // 后面再加 config, history 等，先跑通最简单的

}