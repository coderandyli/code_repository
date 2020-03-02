package com.coderandyli.designpattern.chapter_05.section_35;

import com.google.common.annotations.VisibleForTesting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;


/**
 * ID generator that is used to generate random IDs
 * <p>
 * The IDs generated by this class are not absolutely unique,
 * but probability of duplication is very low
 */
public class RandomIdGenerator implements IdGenerator {
    private static final Logger logger = LoggerFactory.getLogger(RandomIdGenerator.class);

    /**
     * generate the random ID. The IDs may be duplicated only in extreme situation.
     *
     * @return
     */
    @Override
    public String generate() {
        String substrOfHostName = null;
        substrOfHostName = getLastfieldOfHostName();

        long currentTimeMillis = System.currentTimeMillis();
        String randomString = generateRandomAlphameric(8);
        String id = String.format("%s-%d-%s",
                substrOfHostName, currentTimeMillis, randomString);
        return id;
    }

    /**
     * Get the local hostname and extract the last field of the name string splitted by delimiter '.'
     *
     * @return the last field of hostname, returns null if hostname is not obtained
     */
    private String getLastfieldOfHostName(){
        String hostName = null;
        try {
            hostName = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return getLastSubstrSplittedByDot(hostName);
    }

    /***
     * Get the last field of {@hostName} splitted by delemiter '.'.
     * @param hostName should not be null
     * @return the last field of {@hostname}, Returns empty string if  {@hostname} is empty string.
     */
    @VisibleForTesting
    protected String getLastSubstrSplittedByDot(String hostName) {
        String[] tokens = hostName.split("\\.");
        String substrOfHostName = tokens[tokens.length - 1];
        return substrOfHostName;
    }

    /**
     * Get random string which only contains digits, uppercase letters and lowercase letters
     *
     * @param length should not be less than zero
     * @return the random string, Returns empty string if {@length } is zero.
     */
    @VisibleForTesting
    protected String generateRandomAlphameric(int length) {
        char[] randomChars = new char[length];
        int count = 0;
        Random random = new Random();
        while (count < length) {
            int maxAscii = 'z';
            int randomAscii = random.nextInt(maxAscii);
            boolean isDigit = randomAscii >= '0' && randomAscii <= '9';
            boolean isUppercase = randomAscii >= 'A' && randomAscii <= 'Z';
            boolean isLowercase = randomAscii >= 'a' && randomAscii <= 'z';
            if (isDigit || isUppercase || isLowercase) {
                randomChars[count] = (char) (randomAscii);
                ++count;
            }
        }
        return new String(randomChars);
    }
}

//代码使用举例
//    LogTraceIdGenerator logTraceIdGenerator = new RandomIdGenerator();