package Level1.Level1_SecretMap;
// Level 1 : 비밀지도

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String [] OR = new String[n];
        // arr1, arr2 각각 OR연산해서 저장

        for(int i=0; i<OR.length; i++) {
            StringBuilder s = new StringBuilder(Integer.toBinaryString(arr1[i] | arr2[i]));
            // arr1, arr2 각 숫자들에 대한 OR연산를 이진수 형태로 변환
            while(s.length() != n)
                s.insert(0, "0");
                // s의 길이가 n보다 작으면 길이가 n이 될때까지 s의 앞에 "0" 붙여주기
            OR[i] = s.toString();
        }

        String [] result = new String[n];
        // 최종 return 배열
        // 1 -> "#", 0 -> " "

        for(int i=0; i<result.length; i++){
            StringBuilder sb = new StringBuilder();
            for(char c : OR[i].toCharArray()){
                if(c == '1')
                    sb.append("#");
                else if(c == '0')
                    sb.append(" ");
            }
            result[i] = sb.toString();
        }

        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int [] arr1 = {9, 20, 28, 18, 11};
        int [] arr2 = {30, 1, 21, 17, 28};

        String [] result = s.solution(5, arr1, arr2);

        for(String sb : result)
            System.out.println(sb);

        int [] arr3 = {46, 33, 33, 22, 31, 50};
        int [] arr4 = {27, 56, 19, 14, 14, 10};

        String [] result2 = s.solution(6, arr3, arr4);
        System.out.println();
        for(String sb : result2)
            System.out.println(sb);
    }
}
