package com.oldboy.er;

import com.oldboy.java.qq.util.PropertiesUtil;
import org.junit.Test;

public class TestProperties {
    @Test
    public void testPropRead() {
        System.out.println(PropertiesUtil.getStringValue("qq.server.channel.blocking.mode"));
    }
}
