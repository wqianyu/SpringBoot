package com.wuqy.web.controller.log;

import com.wuqy.common.entity.content.JinhongManageLog;
import com.wuqy.common.entity.content.JinhongManageLogExample;
import com.wuqy.common.vo.BaseView;
import com.wuqy.common.vo.Page;
import com.wuqy.service.log.ManagerLogService;
import com.wuqy.web.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 审计日志相关
 * @author wuqy
 * 2020-11-10
 */
@RestController
@RequestMapping("/manageLog")
public class ManagerLogController extends BaseController {

    @Autowired
    private ManagerLogService managerLogService;

    /**
     * 审计日志列表
     * @return
     */
    @RequestMapping("/page")
    @ResponseBody
    public BaseView<JinhongManageLog> pageData() {
        Page<JinhongManageLog> pageData = managerLogService.page(new JinhongManageLogExample(), 1, 10000);
        return new BaseView(pageData);
    }
}
