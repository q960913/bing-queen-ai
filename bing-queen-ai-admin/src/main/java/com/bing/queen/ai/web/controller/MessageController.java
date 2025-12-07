package com.bing.queen.ai.web.controller;

import com.bing.queen.ai.common.annotation.Log;
import com.bing.queen.ai.common.core.controller.BaseController;
import com.bing.queen.ai.common.core.domain.AjaxResult;
import com.bing.queen.ai.common.core.page.TableDataInfo;
import com.bing.queen.ai.common.enums.BusinessType;
import com.bing.queen.ai.common.utils.poi.ExcelUtil;
import com.bing.queen.ai.system.domain.AiMessage;
import com.bing.queen.ai.system.service.IAiMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 聊天
 *
 * @author bing.queen
 */
@RestController
@RequestMapping("/message")
public class MessageController extends BaseController {
    @Autowired
    IAiMessageService aiMessageService;

    /**
     * 查询AI消息列表
     */
    @GetMapping("/list")
    public TableDataInfo list(AiMessage aiMessage)
    {
        startPage();
        List<AiMessage> list = aiMessageService.selectAiMessageList(aiMessage);
        return getDataTable(list);
    }

    /**
     * 导出AI消息列表
     */
    @Log(title = "AI消息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AiMessage aiMessage)
    {
        List<AiMessage> list = aiMessageService.selectAiMessageList(aiMessage);
        ExcelUtil<AiMessage> util = new ExcelUtil<>(AiMessage.class);
        util.exportExcel(response, list, "AI消息数据");
    }

    /**
     * 获取AI消息详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(aiMessageService.selectAiMessageById(id));
    }

    /**
     * 新增AI消息
     */
    @Log(title = "AI消息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AiMessage aiMessage)
    {
        return toAjax(aiMessageService.insertAiMessage(aiMessage));
    }

    /**
     * 修改AI消息
     */
    @Log(title = "AI消息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AiMessage aiMessage)
    {
        return toAjax(aiMessageService.updateAiMessage(aiMessage));
    }

    /**
     * 删除AI消息
     */
    @Log(title = "AI消息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(aiMessageService.deleteAiMessageByIds(ids));
    }
}
