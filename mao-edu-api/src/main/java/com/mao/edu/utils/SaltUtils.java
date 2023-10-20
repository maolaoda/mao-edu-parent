package com.mao.edu.utils;

import java.util.UUID;

/**
 * @author chenyao
 * @date 2023-10-20 10:20
 */
public class SaltUtils
{
    /**
     * 生成盐值
     *
     * @return
     */
    public static String getSalt() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
