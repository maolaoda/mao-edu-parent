package com.mao.edu.utils;

import java.util.UUID;

/**
 * @author chenyao
 * @date 2023-10-20 10:20
 */
public class TokenUtils
{
    public static String getToken() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
