package com.flosslab.tools;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class AlfrescoLogFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        chain.doFilter(request, response);

        if (request instanceof HttpServletRequest) {
            HttpServletRequest httpServletRequest = (HttpServletRequest) request;
            String url = httpServletRequest.getServletPath();

            if (url.startsWith("/alfresco/service/api/solr")) {
                request.setAttribute("doNotLog", "noLog");
            }
        }
    }

    @Override
    public void destroy() {

    }
}
