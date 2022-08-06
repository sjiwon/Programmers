package Level2.Level2_GroupPhoto;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Objects;

class Solution {

    static int count; // 모든 조건 만족하는 경우의 수
    static String[] buffer;
    static boolean[] visited;
    static String[] friends = {"A", "C", "F", "J", "M", "N", "R", "T"};
    
    public int solution(int n, String[] data) {
        count = 0;
        buffer = new String[friends.length];
        visited = new boolean[friends.length];
        batch(data, 0, friends.length);

        return count;
    }
    
    static void batch(String[] data, int selectCount, int target) {
        if (selectCount == target) {
            if (checkCondition(buffer, data)) {
                count++;
            }
        }

        for (int i = 0; i < target; i++) {
            if (!visited[i]) {
                visited[i] = true;
                buffer[selectCount] = friends[i];
                batch(data, selectCount + 1, target);
                buffer[selectCount] = null;
                visited[i] = false;
            }
        }
    }

    static boolean checkCondition(String[] buffer, String[] data) {
        boolean isSuccess = true;

        for (String condition : data) {
            String operator = String.valueOf(condition.charAt(3)); // [=, >, <]
            String[] conditionFriends = new String[]{
                    String.valueOf(condition.charAt(0)),
                    String.valueOf(condition.charAt(2))
            };
            Arrays.sort(conditionFriends);
            int interval = Integer.parseInt(String.valueOf(condition.charAt(4))); // 간격

            isSuccess = validation(buffer, conditionFriends, operator, interval); // 조건 검증
            if (!isSuccess) {
                break;
            }
        }

        return isSuccess;
    }

    static boolean validation(String[] buffer, String[] conditionFriends, String operator, int interval) {
        int indexFirst = findIndex(buffer, conditionFriends[0]); // 첫번째 친구의 index
        int indexSecond = findIndex(buffer, conditionFriends[1]); // 두번째 친구의 index

        if (operator.equals("=")) {
            return (Math.abs(indexSecond - indexFirst) - 1) == interval;
        } else if (operator.equals(">")) {
            return (Math.abs(indexSecond - indexFirst) - 1) > interval;
        } else {
            return (Math.abs(indexSecond - indexFirst) - 1) < interval;
        }
    }

    static int findIndex(String[] buffer, String friend) {
        int result = 0;
        for (int i = 0; i < buffer.length; i++) {
            if (Objects.equals(buffer[i], friend)) {
                result = i;
                break;
            }
        }
        return result;
    }
}

public class Main {
    static void start(int n, String[] data, int expect){
        System.out.println("## 테스트 케이스 ##");
        System.out.println("<N>");
        System.out.println(n + "\n");
        System.out.println("<Data>");
        System.out.println(Arrays.toString(data) + "\n");

        int solution = new Solution().solution(n, data);
        System.out.println("\n<Result>");
        System.out.println(solution + "\n");
        System.out.println("expect(도출한 답) = " + solution + " -> actual(실제 도출되어야 하는 답) = " + expect);
        Assert.assertEquals(solution, expect);
    }

    @Test
    public void 테스트케이스1(){
        start(
                2,
                new String[]{
                        "N~F=0",
                        "R~T>2"
                },
                3648
        );
    }

    @Test
    public void 테스트케이스2(){
        start(
                2,
                new String[]{
                        "M~C<2",
                        "C~M>1"
                },
                0
        );
    }
}
