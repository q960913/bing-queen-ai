package com.bing.queen.ai.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.bing.queen.ai.common.annotation.Excel;
import com.bing.queen.ai.common.core.domain.BaseEntity;

/**
 * AI消息对象 ai_message
 * 
 * @author bing-queen-ai
 * @date 2025-12-05
 */
public class AiMessage extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 消息ID */
    private Long id;

    /** 所属会话ID */
    @Excel(name = "所属会话ID")
    private Long sessionId;

    /** 楼层号(允许不连续) */
    @Excel(name = "楼层号(允许不连续)")
    private Long sortOrder;

    /** 版本状态(1:当前, NULL:历史) */
    @Excel(name = "版本状态(1:当前, NULL:历史)")
    private Integer isCurrent;

    /** 角色(user/model) */
    @Excel(name = "角色(user/model)")
    private String role;

    /** 类型(text/image/file) */
    @Excel(name = "类型(text/image/file)")
    private String type;

    /** 文本内容 或 文件URL */
    @Excel(name = "文本内容 或 文件URL")
    private String content;

    /** 文件元数据(JSON) */
    @Excel(name = "文件元数据(JSON)")
    private String fileMeta;

    /** Token消耗估算 */
    @Excel(name = "Token消耗估算")
    private Long tokenCount;

    /** 错误信息 */
    @Excel(name = "错误信息")
    private String errorMsg;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setSessionId(Long sessionId) 
    {
        this.sessionId = sessionId;
    }

    public Long getSessionId() 
    {
        return sessionId;
    }

    public void setSortOrder(Long sortOrder) 
    {
        this.sortOrder = sortOrder;
    }

    public Long getSortOrder() 
    {
        return sortOrder;
    }

    public void setIsCurrent(Integer isCurrent) 
    {
        this.isCurrent = isCurrent;
    }

    public Integer getIsCurrent() 
    {
        return isCurrent;
    }

    public void setRole(String role) 
    {
        this.role = role;
    }

    public String getRole() 
    {
        return role;
    }

    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }

    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }

    public void setFileMeta(String fileMeta) 
    {
        this.fileMeta = fileMeta;
    }

    public String getFileMeta() 
    {
        return fileMeta;
    }

    public void setTokenCount(Long tokenCount) 
    {
        this.tokenCount = tokenCount;
    }

    public Long getTokenCount() 
    {
        return tokenCount;
    }

    public void setErrorMsg(String errorMsg) 
    {
        this.errorMsg = errorMsg;
    }

    public String getErrorMsg() 
    {
        return errorMsg;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("sessionId", getSessionId())
            .append("sortOrder", getSortOrder())
            .append("isCurrent", getIsCurrent())
            .append("role", getRole())
            .append("type", getType())
            .append("content", getContent())
            .append("fileMeta", getFileMeta())
            .append("tokenCount", getTokenCount())
            .append("errorMsg", getErrorMsg())
            .append("createTime", getCreateTime())
            .toString();
    }
}
