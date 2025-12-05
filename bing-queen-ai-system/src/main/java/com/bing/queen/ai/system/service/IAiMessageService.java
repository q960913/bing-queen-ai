package com.bing.queen.ai.system.service;

import java.util.List;
import com.bing.queen.ai.system.domain.AiMessage;

/**
 * AI消息Service接口
 * 
 * @author bing-queen-ai
 * @date 2025-12-05
 */
public interface IAiMessageService 
{
    /**
     * 查询AI消息
     * 
     * @param id AI消息主键
     * @return AI消息
     */
    public AiMessage selectAiMessageById(Long id);

    /**
     * 查询AI消息列表
     * 
     * @param aiMessage AI消息
     * @return AI消息集合
     */
    public List<AiMessage> selectAiMessageList(AiMessage aiMessage);

    /**
     * 新增AI消息
     * 
     * @param aiMessage AI消息
     * @return 结果
     */
    public int insertAiMessage(AiMessage aiMessage);

    /**
     * 修改AI消息
     * 
     * @param aiMessage AI消息
     * @return 结果
     */
    public int updateAiMessage(AiMessage aiMessage);

    /**
     * 批量删除AI消息
     * 
     * @param ids 需要删除的AI消息主键集合
     * @return 结果
     */
    public int deleteAiMessageByIds(Long[] ids);

    /**
     * 删除AI消息信息
     * 
     * @param id AI消息主键
     * @return 结果
     */
    public int deleteAiMessageById(Long id);
}
