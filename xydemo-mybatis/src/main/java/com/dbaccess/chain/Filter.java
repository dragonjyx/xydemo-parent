package com.dbaccess.chain;

/**
 * 过滤器(责任)
 */
public interface Filter {

    void doFilter(Request req, Response resp, FilterChain chain);

}
