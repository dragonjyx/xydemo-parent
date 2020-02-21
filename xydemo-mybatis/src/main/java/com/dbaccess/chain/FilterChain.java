package com.dbaccess.chain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * 责任链
 */
public class FilterChain {

    //记录调用链上过滤器的位置
    private int index = 0;

    private List<Filter> filters = new ArrayList<Filter>();


    public FilterChain addFilter(Filter filter) {
        filters.add(filter);
        return this;
    }

    public void doFilter(Request req, Response resp) {
        if (index == filters.size()) {
            return;
        }

        //获取filter
        Filter filter = filters.get(index);
        index ++;

        filter.doFilter(req,resp,this);
    }


}
