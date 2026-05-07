class Solution
{
    public int solution(int n, int a, int b)
    {
        a--;
        b--;
        int round = 1;
        while(true) {
            if (a == b) {
                break;
            }
            a /= 2;
            b /= 2;
            round++;
        }
        return round - 1;
    }
}