package com.bing.queen.ai.system.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.bing.queen.ai.common.annotation.Log;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bing.queen.ai.common.core.controller.BaseController;
import com.bing.queen.ai.common.core.domain.AjaxResult;
import com.bing.queen.ai.common.enums.BusinessType;
import com.bing.queen.ai.system.domain.AiSession;
import com.bing.queen.ai.system.service.IAiSessionService;
import com.bing.queen.ai.common.utils.poi.ExcelUtil;
import com.bing.queen.ai.common.core.page.TableDataInfo;

/**
 * AI会话Controller
 * 
 * @author bing-queen-ai
 * @date 2025-12-05
 */
@RestController
@RequestMapping("/system/session")
public class AiSessionController extends BaseController
{
    @Autowired
    private IAiSessionService aiSessionService;

    /**
     * 查询AI会话列表
     */
    @PreAuthorize("@ss.hasPermi('system:session:list')")
    @GetMapping("/list")
    public TableDataInfo list(AiSession aiSession)
    {
        startPage();
        List<AiSession> list = aiSessionService.selectAiSessionList(aiSession);
        return getDataTable(list);
    }

    /**
     * 导出AI会话列表
     */
    @PreAuthorize("@ss.hasPermi('system:session:export')")
    @Log(title = "AI会话", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AiSession aiSession)
    {
        List<AiSession> list = aiSessionService.selectAiSessionList(aiSession);
        ExcelUtil<AiSession> util = new ExcelUtil<AiSession>(AiSession.class);
        util.exportExcel(response, list, "AI会话数据");
    }

    /**
     * 获取AI会话详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:session:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(aiSessionService.selectAiSessionById(id));
    }

    /**
     * 新增AI会话
     */
    @PreAuthorize("@ss.hasPermi('system:session:add')")
    @Log(title = "AI会话", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AiSession aiSession)
    {
        return toAjax(aiSessionService.insertAiSession(aiSession));
    }

    /**
     * 修改AI会话
     */
    @PreAuthorize("@ss.hasPermi('system:session:edit')")
    @Log(title = "AI会话", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AiSession aiSession)
    {
        return toAjax(aiSessionService.updateAiSession(aiSession));
    }

    /**
     * 删除AI会话
     */
    @PreAuthorize("@ss.hasPermi('system:session:remove')")
    @Log(title = "AI会话", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(aiSessionService.deleteAiSessionByIds(ids));
    }
}
