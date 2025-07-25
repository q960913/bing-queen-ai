package com.bing.queen.ai.web.controller.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.bing.queen.ai.common.core.controller.BaseController;
import com.bing.queen.ai.common.core.domain.AjaxResult;
import com.bing.queen.ai.common.core.domain.model.RegisterBody;
import com.bing.queen.ai.common.utils.StringUtils;
import com.bing.queen.ai.framework.web.service.SysRegisterService;
import com.bing.queen.ai.system.service.ISysConfigService;

/**
 * 注册验证
 * 
 * @author bing.queen
 */
@RestController
public class SysRegisterController extends BaseController
{
    @Autowired
    private SysRegisterService registerService;

    @Autowired
    private ISysConfigService configService;

    @PostMapping("/register")
    public AjaxResult register(@RequestBody RegisterBody user)
    {
        if (!("true".equals(configService.selectConfigByKey("sys.account.registerUser"))))
        {
            return error("当前系统没有开启注册功能！");
        }
        String msg = registerService.register(user);
        return StringUtils.isEmpty(msg) ? success() : error(msg);
    }
}
