package helper;

import java.util.Random;

public interface RandomeHelper {

    static String generateEmail() {
        String EMAILRANDOM = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) {
            int index = (int) (rnd.nextFloat() * EMAILRANDOM.length());
            salt.append(EMAILRANDOM.charAt(index));
        }
        String saltStr = String.format("%s", salt);
        return saltStr;
    }

    static String  generatePhoneNumber() {
        String PHONENUMBERRANDOM = "92735";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 5) {
            int index = (int) (rnd.nextFloat() * PHONENUMBERRANDOM.length());
            salt.append(PHONENUMBERRANDOM.charAt(index));
        }
        String saltStr = String.format("%s",salt);
        return saltStr;
    }

}

