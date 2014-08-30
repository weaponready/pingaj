package org.pingaj.app.util.spring.web;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.pingaj.app.util.net.IpUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

/**
 * Creator: JimmyLin
 * DateTime: 14-4-12 下午3:33
 * Summary: 打印请求参数.
 */
public class ReqInfoInterceptor extends HandlerInterceptorAdapter {
    private static final Logger LOG = LoggerFactory.getLogger(ReqInfoInterceptor.class);

    private static final String ATTRIBUTE_TIME = "_attr_time";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Enumeration<?> parameterNames = request.getParameterNames();
        StringBuilder sb = new StringBuilder();
        while (parameterNames.hasMoreElements()) {
            String paramName = (String) parameterNames.nextElement();
            String[] values = request.getParameterValues(paramName);
            sb.append("[").append(paramName).append(":").append(ArrayUtils.toString(values)).append("]");
        }

        String params = StringUtils.isNotEmpty(sb.toString()) ? sb.insert(0, "\n").toString() : "";
        LOG.debug("[{}] =>[{}] [{}]{}", IpUtils.getIpAddr(request), request.getMethod(), request.getRequestURL(), params);
        request.setAttribute(ATTRIBUTE_TIME, System.currentTimeMillis());
        return super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
        LOG.debug("[{}] =>[{}] [{}] cost[{}]ms", IpUtils.getIpAddr(request), request.getMethod(), request.getRequestURL(), (System.currentTimeMillis()-(Long)request.getAttribute(ATTRIBUTE_TIME)));
    }
}
