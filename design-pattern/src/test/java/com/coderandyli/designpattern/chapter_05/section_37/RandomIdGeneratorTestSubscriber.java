package com.coderandyli.designpattern.chapter_05.section_37;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomIdGeneratorTestSubscriber {

    @Test
    public void testGetLastSubstrSplittedByDot() {
        RandomIdGenerator idGenerator = new RandomIdGenerator();
        String actualSubstr = idGenerator.getLastSubstrSplittedByDot("field1.field2.field3");
        Assert.assertEquals("field3", actualSubstr);

        actualSubstr = idGenerator.getLastSubstrSplittedByDot("field1");
        Assert.assertEquals("field1", actualSubstr);

        actualSubstr = idGenerator.getLastSubstrSplittedByDot("field1#field2$field3");
        Assert.assertEquals("field1#field2$field3", actualSubstr);
    }

    // 此单元测试会失败，因为我们在代码中没有处理hostName为null或空字符串的情况
    @Test
    public void testGetLastSubstrSplittedByDot_nullOrEmpty() {
        try {
            RandomIdGenerator idGenerator = new RandomIdGenerator();
            String actualSubstr = idGenerator.getLastSubstrSplittedByDot(null);
            Assert.assertNull(actualSubstr);

            actualSubstr = idGenerator.getLastSubstrSplittedByDot("");
            Assert.assertEquals("", actualSubstr);
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().equals("hostName is null or empty"));
        }
    }

    @Test
    public void testGenerateRandomAlphameric() {
        RandomIdGenerator idGenerator = new RandomIdGenerator();
        String actualRandomString = idGenerator.generateRandomAlphameric(6);
        Assert.assertNotNull(actualRandomString);
        Assert.assertEquals(6, actualRandomString.length());
        for (char c : actualRandomString.toCharArray()) {
            Assert.assertTrue((c >= '0' && c <= '9') || (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z'));
        }
    }

    //没有处理length<=0的情况
    @Test
    public void testGenerateRandomAlphameric_lengthEqualsOrLessThanZero() {
        try {
            RandomIdGenerator idGenerator = new RandomIdGenerator();
            String actualRandomString = idGenerator.generateRandomAlphameric(0);
            Assert.assertEquals("", actualRandomString);
            actualRandomString = idGenerator.generateRandomAlphameric(-1);
            Assert.assertNull(actualRandomString);
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().equals("length less than zero"));
        }

    }

}