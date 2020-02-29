package com.xydemo;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;


public class ApiFindTest {


    @Test
    public void testFindFilm(){

        String appKey    = "25075323";
        String appSecret = "00ee3a1f9d658861d005f10da24327a6";
        String appcode   = "cde1d6bdbf1d4f1d989cf198cc478799";

        Map<String, Object> querys = new HashMap<>();
        querys.put("page", "1");
        querys.put("q", "杀戮都市");

        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Authorization", "APPCODE " + appcode);

        String url = "https://netdisk.market.alicloudapi.com/search";
        HttpRequest request = HttpUtil.createGet(url);
        request.addHeaders(headers);
        request.form(querys);

        String result = request.execute().body();

        System.out.println("--------------------------");
        System.out.println(result);
        System.out.println("--------------------------");

    }



}
