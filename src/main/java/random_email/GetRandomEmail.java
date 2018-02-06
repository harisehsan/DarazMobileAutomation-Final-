package random_email;

import java.util.Random;

public class GetRandomEmail {
    public String getEmailString(){
        String EMAILRANDOM = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new  StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10){
            int index = (int) (rnd.nextFloat() * EMAILRANDOM.length());
            salt.append(EMAILRANDOM.charAt(index));
        }
        String saltStr = String.format("%s", salt);
        return saltStr;
    }
    public static void main (String[] args){
        GetRandomEmail getrandomemail = new GetRandomEmail();
        String email = getrandomemail.getEmailString() + "@hotmail.com";
    }
}
