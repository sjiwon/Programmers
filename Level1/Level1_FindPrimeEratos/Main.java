package Level1.Level1_FindPrimeEratos;
// Level 1 : 소수 찾기

class Solution {
    static boolean [] check;
    public int solution(int n) {
        eratos(n);

        int count = 0;
        for(int i=1; i<=n; i++){
            if(check[i]) {
                count++;
            }
        }

        return count;
    }
    static void eratos(int n){
        // 에라토스테네스의 체 구현
        if(n<=1) return;

        check = new boolean[n+1];

        for(int i=2; i<=n; i++)
            check[i] = true;

        for(int i=2; i*i<=n; i++){
            if(check[i]){
                for(int j=i*i; j<=n; j+=i)
                    check[j] = false;
            }
        }
        // 시간복잡도 : O(n log(log n))
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(10));
        System.out.println(s.solution(5));
    }
}
