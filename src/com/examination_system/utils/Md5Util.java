package com.examination_system.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @program examination-system
 * @description: md5工具类
 * @author: yao
 * @create: 2020/11/14 17:11
 */
public class Md5Util {

    private Md5Util() {

    }

    /**
     * md5加密
     *
     * @param key 要加密的内容
     * @return String
     */
    public static String md5(String key) {
        String string = null;
        char hexDigist[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
            md.update(key.getBytes());
            byte[] datas = md.digest(); //16个字节的长整数

            char[] str = new char[2 * 16];
            int k = 0;

            for (int i = 0; i < 16; i++) {
                byte b = datas[i];
                str[k++] = hexDigist[b >>> 4 & 0xf];//高4位
                str[k++] = hexDigist[b & 0xf];//低4位
            }
            string = new String(str);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return string;
    }

}
