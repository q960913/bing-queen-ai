package com.bing.queen.ai.system.service.impl;

import java.util.List;
import com.bing.queen.ai.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bing.queen.ai.system.mapper.AiSessionMapper;
import com.bing.queen.ai.system.domain.AiSession;
import com.bing.queen.ai.system.service.IAiSessionService;

/**
 * AI会话Service业务层处理
 * 
 * @author bing-queen-ai
 * &#064;date  2025-12-05
 */
@Service
public class AiSessionServiceImpl implements IAiSessionService 
{
    @Autowired
    private AiSessionMapper aiSessionMapper;

    /**
     * 查询AI会话
     * 
     * @param id AI会话主键
     * @return AI会话
     */
    @Override
    public AiSession selectAiSessionById(Long id)
    {
        return aiSessionMapper.selectAiSessionById(id);
    }

    /**
     * 查询AI会话列表
     * 
     * @param aiSession AI会话
     * @return AI会话
     */
    @Override
    public List<AiSession> selectAiSessionList(AiSession aiSession)
    {
        return aiSessionMapper.selectAiSessionList(aiSession);
    }

    /**
     * 新增AI会话
     * 
     * @param aiSession AI会话
     * @return 结果
     */
    @Override
    public int insertAiSession(AiSession aiSession)
    {
        aiSession.setCreateTime(DateUtils.getNowDate());
        return aiSessionMapper.insertAiSession(aiSession);
    }

    /**
     * 创建AI会话
     *
     * @param title AI题目
     * @return 结果
     */
    public int createAiSession( String title){
        AiSession aiSession = new AiSession();
        aiSession.setCreateTime(DateUtils.getNowDate());
        aiSession.setTitle(title);
        return aiSessionMapper.insertAiSession(aiSession);
    }

    /**
     * 修改AI会话
     * 
     * @param aiSession AI会话
     * @return 结果
     */
    @Override
    public int updateAiSession(AiSession aiSession)
    {
        aiSession.setUpdateTime(DateUtils.getNowDate());
        return aiSessionMapper.updateAiSession(aiSession);
    }

    /**
     * 批量删除AI会话
     * 
     * @param ids 需要删除的AI会话主键
     * @return 结果
     */
    @Override
    public int deleteAiSessionByIds(Long[] ids)
    {
        return aiSessionMapper.deleteAiSessionByIds(ids);
    }

    /**
     * 删除AI会话信息
     * 
     * @param id AI会话主键
     * @return 结果
     */
    @Override
    public int deleteAiSessionById(Long id)
    {
        return aiSessionMapper.deleteAiSessionById(id);
    }
}
