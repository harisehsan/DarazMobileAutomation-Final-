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

    static String generateName() {
        String NAMERANDOM = "SKHDFBCLISGCKSGDISAWEKDGSDFASVMVMVMCHGC";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 8) {
            int index = (int) (rnd.nextFloat() * NAMERANDOM.length());
            salt.append(NAMERANDOM.charAt(index));
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

    static String generateResetPass() {
        String RESETPASSWORD = "012345";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 7) {
            int index = (int) (rnd.nextFloat() * RESETPASSWORD.length());
            salt.append(RESETPASSWORD.charAt(index));
        }
        String saltStr = String.format("%s",salt);
        return  saltStr;
    }

}

