import java.util.*;

class Solution {
    public String solution(long n, String[] bans) {
        long[] banNumbers = new long[bans.length];
        for(int i=0;i<bans.length;i++) {
            banNumbers[i] = convertStringToNumber(bans[i]);
        }
        Arrays.sort(banNumbers);
        for(long banNumber : banNumbers) {
            if (banNumber <= n) {
                n++;
            }
        }
        return convertNumberToString(n);
    }
    
    private String convertNumberToString(long number) {
        String string = "";
        while(number > 0) {
            string = String.valueOf((char) ((number - 1) % 26 + 'a')) + string;
            number = (number - 1) / 26;
        }
        return string;
    }
    
    private long convertStringToNumber(String string) {
        long sum = 0;
        long now = 1;
        for(int i=string.length() - 1;i>=0;i--) {
            sum += now * ((int)string.charAt(i) - 'a' + 1); 
            now *= 26;
        }
        return sum;
    }
}