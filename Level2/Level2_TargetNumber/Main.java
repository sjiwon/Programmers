package Level2.Level2_TargetNumber;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

class Solution {

    static int count;

    public int solution(int[] numbers, int target) {
        count = 0;
        dfs(numbers, 0, 0, target);
        return count;
    }

    static void dfs(int[] numbers, int selectCount, int sum, int target) {
        if (selectCount == numbers.length) {
            if (sum == target) {
                count++;
            }
            return;
        }

        // 양수 더하기
        sum += numbers[selectCount];
        dfs(numbers, selectCount + 1, sum, target);

        // 음수 더하기
        sum -= numbers[selectCount];
        sum += numbers[selectCount] * -1;
        dfs(numbers, selectCount + 1, sum, target);
    }
}

public class Main {
    static void start(int[] numbers, int target, int expect){
        System.out.println("## 테스트 케이스 ##");
        System.out.println("<Number List>");
        System.out.println(Arrays.toString(numbers) + "\n");
        System.out.println("<Target>");
        System.out.println(target);

        int solution = new Solution().solution(numbers, target);
        System.out.println("\n<Result>");
        System.out.println(solution + "\n");
        System.out.println("expect(도출한 답) = " + solution + " -> actual(실제 도출되어야 하는 답) = " + expect);
        Assert.assertEquals(solution, expect);
    }

    @Test
    public void 테스트케이스1(){
        start(
                new int[]{1, 1, 1, 1, 1},
                3,
                5
        );
    }

    @Test
    public void 테스트케이스2(){
        start(
                new int[]{4, 1, 2, 1},
                4,
                2
        );
    }
}

/*
테스트 1 〉	통과 (9.76ms, 80.3MB)
테스트 2 〉	통과 (6.51ms, 70.6MB)
테스트 3 〉	통과 (0.22ms, 74.7MB)
테스트 4 〉	통과 (0.40ms, 77.4MB)
테스트 5 〉	통과 (0.62ms, 76.6MB)
테스트 6 〉	통과 (0.25ms, 74.3MB)
테스트 7 〉	통과 (0.32ms, 76.2MB)
테스트 8 〉	통과 (0.40ms, 72.7MB)
 */