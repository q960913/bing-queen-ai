package com.bing.queen.ai.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.bing.queen.ai.common.annotation.Excel;
import com.bing.queen.ai.common.core.domain.BaseEntity;

/**
 * AI会话对象 ai_session
 * 
 * @author bing-queen-ai
 * @date 2025-12-05
 */
public class AiSession extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 会话ID */
    private Long id;

    /** 用户ID(关联sys_user) */
    @Excel(name = "用户ID(关联sys_user)")
    private Long userId;

    /** 会话标题 */
    @Excel(name = "会话标题")
    private String title;

    /** 模型标识 */
    @Excel(name = "模型标识")
    private String model;

    /** 人设/系统指引 */
    @Excel(name = "人设/系统指引")
    private String systemPrompt;

    /** 温度(创意度) */
    @Excel(name = "温度(创意度)")
    private BigDecimal temperature;

    /** 上下文携带条数 */
    @Excel(name = "上下文携带条数")
    private Long historyLimit;

    /** 是否置顶(0否 1是) */
    @Excel(name = "是否置顶(0否 1是)")
    private Integer isPinned;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }

    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }

    public void setModel(String model) 
    {
        this.model = model;
    }

    public String getModel() 
    {
        return model;
    }

    public void setSystemPrompt(String systemPrompt) 
    {
        this.systemPrompt = systemPrompt;
    }

    public String getSystemPrompt() 
    {
        return systemPrompt;
    }

    public void setTemperature(BigDecimal temperature) 
    {
        this.temperature = temperature;
    }

    public BigDecimal getTemperature() 
    {
        return temperature;
    }

    public void setHistoryLimit(Long historyLimit) 
    {
        this.historyLimit = historyLimit;
    }

    public Long getHistoryLimit() 
    {
        return historyLimit;
    }

    public void setIsPinned(Integer isPinned) 
    {
        this.isPinned = isPinned;
    }

    public Integer getIsPinned() 
    {
        return isPinned;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("title", getTitle())
            .append("model", getModel())
            .append("systemPrompt", getSystemPrompt())
            .append("temperature", getTemperature())
            .append("historyLimit", getHistoryLimit())
            .append("isPinned", getIsPinned())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
