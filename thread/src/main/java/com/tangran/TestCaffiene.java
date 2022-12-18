package com.tangran;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;

import java.util.concurrent.TimeUnit;

/**
 * @ Author     ：tangran
 * @ Date       ：Created in 11:00 下午 2022/3/7
 */
public class TestCaffiene {
    public static void main(String[] args) {
        Cache<Object, Object> cache = Caffeine.newBuilder().expireAfterWrite(1, TimeUnit.SECONDS)
                .expireAfterAccess(1, TimeUnit.SECONDS)
                .maximumSize(10)
                .build();

        
    }
}
