import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            
            int answer = c / Math.min(a, b);
            System.out.println("#"+test_case+" "+answer);
        }
	}
}