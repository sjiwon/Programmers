package Level1.Level1_AddMissingNum;
// Level 1 : 없는 숫자 더하기

class Solution {
    public int solution(int[] numbers) {
        int [] count = new int[10];
        int answer = 0;

        for(int i=0; i<numbers.length; i++){
            count[numbers[i]]++;
        }
        for(int i=0; i<count.length; i++){
            if(count[i] == 0)
                answer+=i;
        }
        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int [] numbers1 = {1, 2, 3, 4, 6, 7, 8, 0};
        int [] numbers2 = {5, 8, 4, 0, 6, 7, 9};
        System.out.println(s.solution(numbers1));
        System.out.println(s.solution(numbers2));
    }
}
