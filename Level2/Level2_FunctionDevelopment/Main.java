package Level2.Level2_FunctionDevelopment;

import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Stack<Integer> stack = new Stack<>();

        for(int i = progresses.length - 1; i >= 0; i--){
            int value = (int) Math.ceil((double)(100 - progresses[i]) / speeds[i]);

            stack.push(value);
            /*
            [93, 30, 55] / [1, 30, 5]
            -> (stack : pop() 기준) 7 3 9
            --> 7일에 2개, 9일에 1개

            [95, 90, 99, 99, 80, 99] / [1, 1, 1, 1, 1, 1]
            -> (stack : pop() 기준) 5 10 1 1 20 1
            --> 5일에 1개, 10일에 3개, 20일에 2개
             */
        }

        ArrayList<Integer> list = new ArrayList<>();
        while(!stack.isEmpty()){
            int top = stack.pop();
            int count = 1;

            while(!stack.isEmpty()){
                int compare = stack.peek();
                if(top >= compare){
                    stack.pop();
                    count++;
                }
                else{
                    break;
                }
            }
            list.add(count);
        }

        int [] result = new int[list.size()];

        for(int i=0; i<list.size(); i++){
            result[i] = list.get(i);
        }

        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int [] p1 = {93, 30, 55};
        int [] s1 = {1, 30, 5};

        int [] p2 = {95, 90, 99, 99, 80, 99};
        int [] s2 = {1, 1, 1, 1, 1, 1};

        System.out.println(Arrays.toString(s.solution(p1, s1)));
        System.out.println(Arrays.toString(s.solution(p2, s2)));
    }
}
