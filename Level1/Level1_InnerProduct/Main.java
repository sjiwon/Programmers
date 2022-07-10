package Level1.Level1_InnerProduct;
// Level 1 : 내적

class Solution {
    public int solution(int[] a, int[] b) {
        int sum = 0;
        for(int i=0; i<a.length; i++)
            sum += a[i]*b[i];
        return sum;
    }
}
