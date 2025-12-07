package com.bing.queen.ai.system.service;

import java.util.List;
import com.bing.queen.ai.system.domain.AiSession;

/**
 * AI会话Service接口
 * 
 * @author bing-queen-ai
 * @date 2025-12-05
 */
public interface IAiSessionService 
{
    /**
     * 查询AI会话
     * 
     * @param id AI会话主键
     * @return AI会话
     */
    public AiSession selectAiSessionById(Long id);

    /**
     * 查询AI会话列表
     * 
     * @param aiSession AI会话
     * @return AI会话集合
     */
    public List<AiSession> selectAiSessionList(AiSession aiSession);

    /**
     * 新增AI会话
     * 
     * @param aiSession AI会话
     * @return 结果
     */
    public int insertAiSession(AiSession aiSession);

    /**
     * 创建AI会话
     *
     * @param title AI题目
     * @return 结果
     */
    public int createAiSession( String title);

    /**
     * 修改AI会话
     * 
     * @param aiSession AI会话
     * @return 结果
     */
    public int updateAiSession(AiSession aiSession);

    /**
     * 批量删除AI会话
     * 
     * @param ids 需要删除的AI会话主键集合
     * @return 结果
     */
    public int deleteAiSessionByIds(Long[] ids);

    /**
     * 删除AI会话信息
     * 
     * @param id AI会话主键
     * @return 结果
     */
    public int deleteAiSessionById(Long id);
}
