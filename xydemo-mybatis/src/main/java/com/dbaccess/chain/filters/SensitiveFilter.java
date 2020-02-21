package com.dbaccess.chain.filters;

import com.dbaccess.chain.Filter;
import com.dbaccess.chain.FilterChain;
import com.dbaccess.chain.Request;
import com.dbaccess.chain.Response;

/**
 * 敏感词过滤器
 */
public class SensitiveFilter implements Filter {

    @Override
    public void doFilter(Request req, Response resp, FilterChain chain) {
        System.out.println("----------SensitiveFilter----------");

        String reqParams = req.getParams();
        reqParams = reqParams.replace("法沦功","邪教").replace("垃圾","**");
        req.setParams(reqParams);

        String str= "--- 经过SensitiveFilter（敏感词过滤器) ---";
        resp.setParams(str);

        //传给下一个过滤器
        chain.doFilter(req,resp);
    }

}
