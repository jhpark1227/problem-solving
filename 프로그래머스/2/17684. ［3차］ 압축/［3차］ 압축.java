import java.util.*;

class Solution {
    private List<String> dictionary = new ArrayList<>();

    public int[] solution(String msg) {
        for(int i=(int)'A';i<=(int)'Z';i++) {
            dictionary.add(String.valueOf((char)i));
        }
        List<Integer> answer = new ArrayList<>();
        while(!msg.isEmpty()) {
            for(int i=msg.length();i>=0;i--) {
                String substring = msg.substring(0, i);
                int index = findDictionary(substring);
                if (index == -1) continue;
                answer.add(index);
                msg = msg.substring(i);
                if (!msg.isEmpty()) {
                    dictionary.add(substring + msg.charAt(0));
                }
                break;
            }
        }
        
        int[] arr = new int[answer.size()];
        for(int i=0;i<arr.length;i++) {
            arr[i] = answer.get(i);
        }
        return arr;
    }
    
    private int findDictionary(String msg) {
        for(int i=0;i<dictionary.size() ;i++) {
            if (dictionary.get(i).equals(msg)) {
                return i + 1;
            }
        }
        return -1;
    }
}