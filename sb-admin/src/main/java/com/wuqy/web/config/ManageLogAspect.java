package com.wuqy.web.config;

import com.wuqy.common.entity.content.JinhongAccount;
import com.wuqy.common.entity.content.JinhongManageLog;
import com.wuqy.common.log.ManagerLog;
import com.wuqy.common.vo.BaseView;
import com.wuqy.common.vo.RspConstants;
import com.wuqy.service.log.ManagerLogService;
import com.wuqy.web.util.LoginUtils;
import com.wuqy.web.util.SendMsgUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;

/**
 * aop拦截收集后台日志并保存
 * @author wuqy
 * 2020-11-27
 */
@Slf4j
@Aspect
@Component
public class ManageLogAspect {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ManagerLogService logService;

    /**
     * Controller层切点 注解拦截
     * ("execution(public * com.wuqy.web.controller.*.*(..))")包路径拦截
     */
    @Pointcut("@annotation(com.wuqy.common.log.ManagerLog)")
    public void logPointCut(){}

    /**
     * 前置通知：在连接点之前执行的通知
     * @param joinPoint
     * @throws Throwable
     */
    @Before("logPointCut()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 记录下请求内容
        logger.info("URL : " + request.getRequestURL().toString());
        logger.info("HTTP_METHOD : " + request.getMethod());
        logger.info("IP : " + request.getRemoteAddr());
        logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(pointcut = "logPointCut()", returning = "ret")
    public void doAfterReturning(JoinPoint joinPoint, Object ret) {
        // 处理完请求，返回内容
        logger.info("RESPONSE doAfterReturning: " + ret);
        ManagerLog log = getAnnotationInfo(joinPoint);
        if(ret instanceof BaseView) {
            BaseView base = (BaseView) ret;
            if(null != base.getLog()) {
                RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
                //从获取RequestAttributes中获取HttpServletRequest的信息
                HttpServletRequest request = (HttpServletRequest) requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);
                logService.saveLog(JinhongManageLog.builder().account(base.getLog().getAccount()).ip(LoginUtils.getSourceIp(request)).
                        operate(log.operate()).module(log.module()).createTime(new Date()).msg(base.getLog().getMsg())
                        .nick(base.getLog().getNick()).result(base.getLog().getResult()).
                        build());
            }
        }
        logger.info("ANNOTATON doAfterReturning module:{}, operate:{}", log.module(), log.operate());
    }

    /**
     *  异常通知 记录操作报错日志
     * @param joinPoint
     * @param e
     */
    @AfterThrowing(pointcut = "logPointCut()", throwing = "e")
    public void doAfterThrowing(JoinPoint joinPoint, Throwable e) {
        logger.warn("ANNOTATON doAfterThrowing: " + getAnnotationInfo(joinPoint));
        ManagerLog log = getAnnotationInfo(joinPoint);
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        //从获取RequestAttributes中获取HttpServletRequest的信息
        HttpServletRequest request = (HttpServletRequest) requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);
        JinhongAccount sessionAccount = LoginUtils.getUser(request);
        String account = "";
        String nick = "";
        if(null != sessionAccount) {
            account = sessionAccount.getAccount();
            nick = sessionAccount.getNick();
        }
        logService.saveLog(JinhongManageLog.builder().
                operate(log.operate()).module(log.module()).createTime(new Date()).ip(LoginUtils.getSourceIp(request)).
                msg(RspConstants.EXCEPTION_MSG).result(RspConstants.EXCEPTION).account(account).nick(nick).
                        build());

        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        LoginUtils.setCors(response);
        BaseView baseView = BaseView.builder().code(RspConstants.EXCEPTION).msg(RspConstants.EXCEPTION_MSG).build();
        try {
            SendMsgUtil.sendJsonMessage(response, baseView);
        } catch (Exception e1) {
            logger.warn("doAfterThrowing sendJsonMessage error", e);
        }
    }

    /**
     * 获取注解中对方法的描述信息 用于service层注解
     * @param joinPoint
     * @return discription
     */
    public static ManagerLog getAnnotationInfo(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        ManagerLog serviceLog = method
                .getAnnotation(ManagerLog.class);
        return serviceLog;
    }
}
