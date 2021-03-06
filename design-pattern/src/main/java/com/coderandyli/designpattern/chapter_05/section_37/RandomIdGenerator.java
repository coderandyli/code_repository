package com.coderandyli.designpattern.chapter_05.section_37;

import com.google.common.annotations.VisibleForTesting;
import org.apache.commons.lang3.StringUtils;
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
    public String generate() throws IdGenerationFailureException {
        String substrOfHostName = null;
        try {
            substrOfHostName = getLastfieldOfHostName();
        } catch (UnknownHostException e) {
            e.printStackTrace();
            throw new IdGenerationFailureException("host name is empty.");
        }
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
    private String getLastfieldOfHostName() throws UnknownHostException {
        String substrOfHostName = null;
        String hostName = InetAddress.getLocalHost().getHostName();
        if (hostName == null || hostName.isEmpty()) {
            // 此处做判断
            throw new UnknownHostException("unknown host");
        }
        substrOfHostName = getLastSubstrSplittedByDot(hostName);
        return substrOfHostName;
    }

    /***
     * Get the last field of {@hostName} splitted by delemiter '.'.
     * @param hostName should not be null
     * @return the last field of {@hostname}, Returns empty string if  {@hostname} is empty string.
     */
    @VisibleForTesting
    protected String getLastSubstrSplittedByDot(String hostName) {
        if (StringUtils.isBlank(hostName)) {
            throw new IllegalArgumentException("hostName is null or empty"); //运行时异常
        }
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
        if (length <= 0) {
            throw new IllegalArgumentException("length less than zero");
        }
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

    public static void main(String[] args) {
        try {
            String generate = new RandomIdGenerator().generate();
            System.out.println(generate);
        } catch (IdGenerationFailureException e) {
            e.printStackTrace();
        }
    }
}



//代码使用举例
//    LogTraceIdGenerator logTraceIdGenerator = new RandomIdGenerator();