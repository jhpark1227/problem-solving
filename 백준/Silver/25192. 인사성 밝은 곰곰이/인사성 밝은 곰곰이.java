import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        int answer = 0;
        for(int i=0;i<n;i++){
            String input = br.readLine();
            if(input.equals("ENTER")){
                set.clear();
                continue;
            }
            if(!set.contains(input)){
                answer++;
                set.add(input);
            }
        }
        System.out.print(answer);
    }
}