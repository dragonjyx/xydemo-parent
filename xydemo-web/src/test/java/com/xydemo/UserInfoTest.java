package com.xydemo;

import com.xydemo.utils.encrypt.MD5Util;
import com.xydemo.utils.uniqueid.UniqueIdGenerate;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class UserInfoTest {


    @Test
    public void testUserInfO() {

        String userId = UniqueIdGenerate.getId("userInfoId",32);
        String ukey = UniqueIdGenerate.getId("userInfoKey",16);
        String password = "alog1234";
        String email = "xloy@alog.com";
        String mobile= "15626222192";

        String md5Pwd = MD5Util.md5Encrypt32(password + ukey);

        System.out.println("userId:"+userId);
        System.out.println("ukey:"+ukey);
        System.out.println("password:"+password);
        System.out.println("md5Pwd:"+md5Pwd);
        System.out.println("email:"+email);
        System.out.println("mobile:"+mobile);





    }

    @Test
    public void testList(){

        String[] s = {"aa","bb","cc"};
        List<String> strlist = Arrays.asList(s);
        System.out.println(strlist.toString());
        s[1] = "ddddd";
        System.out.println(strlist.toString());
    }


}
