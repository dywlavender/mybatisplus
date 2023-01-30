package com.baidu.mybatisplus.threadPool;

import org.slf4j.MDC;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;


/**
 * traceId拦截器
 *  从header中获取traceId，如果没有则UUID生成一个
 */
@Service
public class TraceInterceptor implements HandlerInterceptor {
    public static final String LOG_TRACE_ID = "traceId";
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        MDC.put("traceId","");
        String traceId = request.getHeader(LOG_TRACE_ID);
        if (!StringUtils.hasLength(traceId)){
            traceId = UUID.randomUUID().toString();
            MDC.put(LOG_TRACE_ID,traceId);
        }else {
            MDC.put(LOG_TRACE_ID,traceId);
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        MDC.remove(LOG_TRACE_ID);
    }
}
