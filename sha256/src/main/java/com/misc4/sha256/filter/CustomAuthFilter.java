package com.misc4.sha256.filter;

import com.misc4.sha256.util.ShaAuthUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CustomAuthFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(CustomAuthFilter.class);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        ServletRequest requestWrapper = null;

        if (servletRequest instanceof HttpServletRequest) {
            requestWrapper = new CustomHttpServletRequestWrapper((HttpServletRequest) servletRequest);
        }

        if (requestWrapper == null) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            doHttpFilter(filterChain, (HttpServletRequest) requestWrapper, (HttpServletResponse) servletResponse);
        }
    }

    protected void doHttpFilter(FilterChain filterChain, HttpServletRequest request, HttpServletResponse httpServletResponse)
            throws IOException, ServletException {
        if (!requiresAuth(request)) {
            filterChain.doFilter(request, httpServletResponse);
            return;
        }

        if (isAuthorised(request)) {
            filterChain.doFilter(request, httpServletResponse);
        } else {
            logger.warn("unauthorised request made");
            httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, "UNAUTHORISED");
        }
    }

    private boolean requiresAuth(HttpServletRequest request) {
        if(request.getRequestURI().equals("/auth/httpRequestAuth")){
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    boolean isAuthorised(HttpServletRequest req) {
        Boolean isAuthorised = Boolean.FALSE;
        String digitalSignature = req.getHeader("Digital-Signature");
        if (null == digitalSignature) {
            return isAuthorised;
        }

        CustomHttpServletRequestWrapper request = new CustomHttpServletRequestWrapper(req);
        String payload = null;
        if (null != request) {
            payload = request.getBody();
        }

        if (null != payload) {
            String shaSignature = ShaAuthUtil.getSha256Signature("dummyKey1", payload);
            if (null != shaSignature && shaSignature.equals(digitalSignature)) {
                isAuthorised = Boolean.TRUE;
            } else {
                isAuthorised = Boolean.FALSE;
            }
        } else {
            isAuthorised = Boolean.FALSE;
        }
        return isAuthorised;
    }

}
