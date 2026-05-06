class Solution {
    public String solution(String s) {
        String answer = "";
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if (i==0 || s.charAt(i - 1) == ' ') {
                if (c >= 'a' && c <= 'z')  {
                    answer += (char)(c + 'A' - 'a');
                    continue;
                }
                answer += c;
                continue;
            }    
            if (c >= 'A' && c <= 'Z') {
                answer += (char)(c - ('A' - 'a'));
                continue;
            }
            answer += c;
        }
        return answer;
    }
}