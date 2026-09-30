import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Set<String> set = new HashSet<>();
        for(String phone : phone_book) {
            phone = phone.replace(" ", "");
            for(int i=1;i<phone.length();i++) {
                set.add(phone.substring(0, i));
            }
        }
        for(String phone : phone_book) {
            if (set.contains(phone.replace(" ", ""))) return false;
        }
        return true;
    }
}