package com.dbaccess.chain.filters;

import com.dbaccess.chain.Filter;
import com.dbaccess.chain.FilterChain;
import com.dbaccess.chain.Request;
import com.dbaccess.chain.Response;

/**
 * HTML过滤器
 */
public class HtmlFilter implements Filter {

    @Override
    public void doFilter(Request req, Response resp, FilterChain chain) {
        System.out.println("----------HtmlFilter----------");

        String reqParams = req.getParams();
        String params = reqParams.replace("<", "&lt;").replace(">", "&gt;");
        req.setParams(params);

        String str= "--- 经过HtmlFilter（HTML过滤器) ---";
        resp.setParams(str);

        //传给下一个过滤器
        chain.doFilter(req,resp);
    }

}
