package com.wuqy.web.controller.visit;

import com.wuqy.common.entity.content.JinhongAccount;
import com.wuqy.common.entity.content.JinhongUserVisit;
import com.wuqy.common.entity.content.JinhongUserVisitExample;
import com.wuqy.common.vo.BaseView;
import com.wuqy.common.vo.Page;
import com.wuqy.common.vo.RspConstants;
import com.wuqy.service.visit.VisitLogService;
import com.wuqy.web.controller.BaseController;
import com.wuqy.web.util.LoginUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

import java.util.Date;


/**
 * 用户访问相关
 * @author wuqy
 * 2020-11-10
 */
@RestController
@RequestMapping("/visit")
public class UserVisitController extends BaseController {

    @Autowired
    private VisitLogService visitLogService;

    /**
     * 插入访问日志
     * @param request
     * @param visit
     * @return
     */
    @RequestMapping("/insert")
    @ResponseBody
    public BaseView insert(HttpServletRequest request, JinhongUserVisit visit) {
        if(null != visit) {
            JinhongAccount account = LoginUtils.getUser(request);
            if(StringUtils.isEmpty(visit.getAccount())) {
                visit.setAccount(null==account?RspConstants.VISIT:account.getAccount());
            }
            if(StringUtils.isEmpty(visit.getNick())) {
                visit.setNick(null==account? RspConstants.VISIT:account.getNick());
            }
            if(null == visit.getCreateTime()) {
                visit.setCreateTime(new Date());
            }
            if(StringUtils.isEmpty(visit.getIp())) {
                visit.setIp(LoginUtils.getSourceIp(request));
            }
            visitLogService.insert(visit);
            return BaseView.builder().code(RspConstants.SUCCESS).msg(RspConstants.SUCCESS_MSG).
                    build();
        } else {
            return BaseView.builder().code(RspConstants.FAIL).msg(RspConstants.EMPTY).
                    build();
        }
    }

    /**
     * 查询访问日志
     * @return
     */
    @RequestMapping("/page")
    @ResponseBody
    public BaseView<JinhongUserVisit> pageData() {
        Page<JinhongUserVisit> pageData = visitLogService.page(new JinhongUserVisitExample(), 1, 10000);
        return new BaseView(pageData);
    }
}
