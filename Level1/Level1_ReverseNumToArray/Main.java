package Level1.Level1_ReverseNumToArray;
// Level 1 : 자연수 뒤집어 배열로 만들기

class Solution {
    public int[] solution(long n) {
        StringBuilder sb = new StringBuilder(String.valueOf(n));
        sb.reverse();
        String s = sb.toString();

        int [] result = new int[s.length()];

        int i = 0;
        for(String w : s.split("")){
            result[i] = Integer.parseInt(w);
            i++;
        }

        return result;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
