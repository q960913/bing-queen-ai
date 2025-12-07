package com.bing.queen.ai.web.controller;

import com.bing.queen.ai.common.annotation.Log;
import com.bing.queen.ai.common.core.controller.BaseController;
import com.bing.queen.ai.common.core.domain.AjaxResult;
import com.bing.queen.ai.common.core.page.TableDataInfo;
import com.bing.queen.ai.common.enums.BusinessType;
import com.bing.queen.ai.system.domain.AiSession;
import com.bing.queen.ai.system.service.IAiSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 参数配置 对话列表
 *
 * @author bing.queen
 */
@RestController
@RequestMapping("/session")
public class SessionController extends BaseController {
    @Autowired
    IAiSessionService aiSessionService;

    /**
     * 查询AI会话列表
     */
    @GetMapping("/list")
    public TableDataInfo list(AiSession aiSession)
    {
        startPage();
        List<AiSession> list = aiSessionService.selectAiSessionList(aiSession);
        return getDataTable(list);
    }

    /**
     * 获取AI会话详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(aiSessionService.selectAiSessionById(id));
    }

    /**
     * 新增AI会话
     */
    @Log(title = "AI会话", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestParam String title)
    {
        return toAjax(aiSessionService.createAiSession(title));
    }

    /**
     * 修改AI会话
     */
    @Log(title = "AI会话", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AiSession aiSession)
    {
        return toAjax(aiSessionService.updateAiSession(aiSession));
    }

    /**
     * 删除AI会话
     */
    @Log(title = "AI会话", businessType = BusinessType.DELETE)
    @DeleteMapping("/id")
    public AjaxResult remove(@PathVariable Long id)
    {
        return toAjax(aiSessionService.deleteAiSessionById(id));
    }
}
