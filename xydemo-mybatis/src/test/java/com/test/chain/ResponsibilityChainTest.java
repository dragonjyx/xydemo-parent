package com.test.chain;

import com.dbaccess.chain.FilterChain;
import com.dbaccess.chain.Request;
import com.dbaccess.chain.Response;
import com.dbaccess.chain.filters.HtmlFilter;
import com.dbaccess.chain.filters.SensitiveFilter;
import org.junit.Test;

public class ResponsibilityChainTest {


    @Test
    public void testFilter(){

        String message = "<script>他曾经加入法沦功，被公安机关抓了，现在靠捡垃圾生活</script>";

        Request req = new Request();
        Response resp = new Response();

        req.setParams(message);

        resp.setParams("response msg:");

        FilterChain chain = new FilterChain();
        chain.addFilter(new SensitiveFilter()).addFilter(new HtmlFilter());

        System.out.println("message过滤之前：" + message);
        chain.doFilter(req,resp);

        System.out.println("message过滤之后：" + req.getParams());

        System.out.println("resp过滤之后：" + resp.getParams());


    }



}
