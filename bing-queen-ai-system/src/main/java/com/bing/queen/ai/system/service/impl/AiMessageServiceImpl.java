package com.bing.queen.ai.system.service.impl;

import java.util.List;
import com.bing.queen.ai.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bing.queen.ai.system.mapper.AiMessageMapper;
import com.bing.queen.ai.system.domain.AiMessage;
import com.bing.queen.ai.system.service.IAiMessageService;

/**
 * AI消息Service业务层处理
 * 
 * @author bing-queen-ai
 * @date 2025-12-05
 */
@Service
public class AiMessageServiceImpl implements IAiMessageService 
{
    @Autowired
    private AiMessageMapper aiMessageMapper;

    /**
     * 查询AI消息
     * 
     * @param id AI消息主键
     * @return AI消息
     */
    @Override
    public AiMessage selectAiMessageById(Long id)
    {
        return aiMessageMapper.selectAiMessageById(id);
    }

    /**
     * 查询AI消息列表
     * 
     * @param aiMessage AI消息
     * @return AI消息
     */
    @Override
    public List<AiMessage> selectAiMessageList(AiMessage aiMessage)
    {
        return aiMessageMapper.selectAiMessageList(aiMessage);
    }

    /**
     * 新增AI消息
     * 
     * @param aiMessage AI消息
     * @return 结果
     */
    @Override
    public int insertAiMessage(AiMessage aiMessage)
    {
        aiMessage.setCreateTime(DateUtils.getNowDate());
        return aiMessageMapper.insertAiMessage(aiMessage);
    }

    /**
     * 修改AI消息
     * 
     * @param aiMessage AI消息
     * @return 结果
     */
    @Override
    public int updateAiMessage(AiMessage aiMessage)
    {
        return aiMessageMapper.updateAiMessage(aiMessage);
    }

    /**
     * 批量删除AI消息
     * 
     * @param ids 需要删除的AI消息主键
     * @return 结果
     */
    @Override
    public int deleteAiMessageByIds(Long[] ids)
    {
        return aiMessageMapper.deleteAiMessageByIds(ids);
    }

    /**
     * 删除AI消息信息
     * 
     * @param id AI消息主键
     * @return 结果
     */
    @Override
    public int deleteAiMessageById(Long id)
    {
        return aiMessageMapper.deleteAiMessageById(id);
    }
}
