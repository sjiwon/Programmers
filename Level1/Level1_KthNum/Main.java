package Level1.Level1_KthNum;
// Level 1 : K번째 수

import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i=0; i<answer.length; i++){
            answer[i] = cut_array(array, commands[i][0], commands[i][1])[commands[i][2]-1];
        }

        return answer;
    }

    static int [] cut_array(int [] array, int start, int end){
        int [] result = new int[end-start+1];
        int k = 0;
        for(int i=start-1; i<=end-1; i++){
            result[k] = array[i];
            k++;
        }
        Arrays.sort(result);
        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        int [] array = {1, 5, 2, 6, 3, 7, 4};
        int [][] commands = {
                {2, 5, 3},
                {4, 4, 1},
                {1, 7, 3}
        };
        Solution s = new Solution();

        int [] result = s.solution(array, commands);
        for(int i=0; i<result.length; i++)
            System.out.println(result[i]);
    }
}
