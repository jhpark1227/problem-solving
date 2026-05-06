import java.util.*;

class Solution {
    private int answer = 0;
    
    public int solution(int n) {
        dfs(new ArrayList<>(), n);
        return answer;
    }
    
    private void dfs(List<Integer> list, int n) {
        if (list.size() == n) {
            answer++;
            return;
        }
        
        for(int i=0;i<n;i++) {
            boolean check = true;
            for(int j=0;j<list.size();j++) {
                if (list.get(j) == i) {
                    check = false;
                    break;
                }
                if (Math.abs(list.get(j) - i) == Math.abs(list.size() - j)) {
                    check = false;
                    break;
                }
            }
            if (check) {
                list.add(i);
                dfs(list, n);
                list.remove(Integer.valueOf(i));    
            }
        }
    }
}