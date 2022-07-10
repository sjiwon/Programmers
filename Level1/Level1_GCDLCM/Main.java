package Level1.Level1_GCDLCM;
// Level 1 : 최대공약수와 최소공배수

class Solution {
    public int[] solution(int n, int m) {
        return new int[]{GCD(n, m), (n*m)/GCD(n, m)};
    }
    static int GCD(int A, int B){
        if(B==0) return A;
        else return GCD(B, A%B);
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
