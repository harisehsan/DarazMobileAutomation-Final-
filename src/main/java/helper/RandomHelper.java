package helper;

import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public class RandomHelper {

    private static final String EMAIL_PREFIX = "LAZADATEST_1111_";
    private static final String EMAIL_SUFFIX = "@MAILINATOR.COM";
    private static final int EMAIL_LENGTH = 16;
    private static final String MISSING_NUMBER= "x";

    public static String randomAlphabetString(int length){
        return RandomStringUtils.randomAlphabetic(length);
    }

    public static String randomAlphaNumericString(int length){
        return RandomStringUtils.randomAlphanumeric(length);
    }

    public static String randomTestMail(){
        return EMAIL_PREFIX + randomAlphaNumericString(EMAIL_LENGTH) + EMAIL_SUFFIX;
    }

    /**
     * template should be: 789xxxxxxxx
     * x should be the random from 0-9
     * @param template
     * @return
     */
    public static String randomPhoneNumber(String template){
        String prefixPhone = template.replace(MISSING_NUMBER,"");
        int suffixPhoneLength = template.length() - template.replace(MISSING_NUMBER, "").length();
        return prefixPhone+randomNumber(suffixPhoneLength);
    }



    public static String randomNumber(int length){
        StringBuilder stringBuilder = new StringBuilder();
        Random randomGenerator = new Random();
        while (stringBuilder.length() < length) {
            int number = randomGenerator.nextInt(10);
            stringBuilder.append(number);
        }
        return stringBuilder.toString();
    }

    /**
     * Generate a random sentence with Lorem Ipsum
     * @param numberOfWords
     * @return
     */
    public static String randomSentence(int numberOfWords){
        Lorem loremIpsum = LoremIpsum.getInstance();
        return loremIpsum.getWords(numberOfWords);
    }

    public static int randomNumberInRange (int max, int min) {
        Random random = new Random();
        return random.nextInt(max - min +1) + min;
    }
}
