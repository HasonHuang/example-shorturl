/*
 * Copyright 2017 - 2018 探物科技 All Rights Reserved
 */
package com.hason.shorturl;

import com.hason.shorturl.client.SinaHttpUrlConverter;
import org.junit.Before;
import org.junit.Test;

/**
 * Url Converter Unit Test
 *
 * @author Huanghs
 * @since 1.0
 * @date 2018/11/9
 */
public class UrlConverterTest {

    private UrlConverter converter;
    private String shorten;

    @Before
    public void init() {
        converter = new SinaHttpUrlConverter();
    }

    @Test
    public void testShorten() {
        String longUrl = "https://baidu.com";
        shorten = converter.shorten(longUrl);
    }

    @Test
    public void testLengthen() {
        testShorten();
        converter.lengthen(shorten);
    }

}
