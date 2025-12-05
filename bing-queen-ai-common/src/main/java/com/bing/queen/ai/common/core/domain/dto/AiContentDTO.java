package com.bing.queen.ai.common.core.domain.dto;

public class AiContentDTO {
    private String type; // "text" 或 "image"
    private String data; // "你好" 或 图片URL

    // 构造方法
    public AiContentDTO(String type, String data) {
        this.type = type;
        this.data = data;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}