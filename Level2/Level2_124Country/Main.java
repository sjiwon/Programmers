package Level2.Level2_124Country;

import org.junit.Assert;
import org.junit.Test;

/*
## 3으로 나눴을 때 몫 & 나머지 {"4", "1", "2"} ##
1 -> [0, 1] >> "1"
2 -> [0, 2] >> "2"
3 -> [1, 0] -> [0, 1] >> "4"

4 -> [1, 1] -> [0, 1] >> "11"
5 -> [1, 2] -> [0, 1] >> "12"
6 -> [2, 0] -> [0, 2] >> "14"

7 -> [2, 1] -> [0, 2] >> "21"
8 -> [2, 2] -> [0, 2] >> "22"
9 -> [3, 0] -> [1, 0] -> [0, 1] >> "24"

10 -> [3, 1] -> [1, 0] -> [0, 1] >> "41"
11 -> [3, 2] -> [1, 0] -> [0, 1] >> "42"
12 -> [4, 0] -> [1, 1] -> [0, 1] >> "44"

13 -> [4, 1] -> [1, 1] -> [0, 1] >> "111"
14 -> [4, 2] -> [1, 1] -> [0, 1] >> "112"
15 -> [5, 0] -> [1, 2] -> [0, 1] >> "114"

16 -> [5, 1] -> [1, 2] -> [0, 1] >> "121"
17 -> [5, 2] -> [1, 2] -> [0, 1] >> "122"
18 -> [6, 0] -> [2, 0] -> [0, 2] >> "124"
 */

class Solution {

    static final String[] iterative = {"4", "1", "2"};

    public String solution(int n) {
        StringBuilder sb = new StringBuilder();

        while (n > 3) {
            sb.insert(0, iterative[n % 3]);
            if (n % 3 == 0) {
                n = n / 3 - 1; // [3n-1, 3n-2, 3n]이 하나의 Cycle이므로 몫도 동일하게 가져가야 하기 때문에 "-1"
            } else {
                n /= 3;
            }
        }
        sb.insert(0, iterative[n % 3]); // 마지막 몫까지 앞단에 추가 (IndexBound 방지 -> "% 3")

        return sb.toString();
    }
}

public class Main {
    static void start(int n, String expect){
        System.out.println("## 테스트 케이스 ##");
        System.out.println("<n>");
        System.out.println("n = " + n);

        String solution = new Solution().solution(n);
        System.out.println("\n<Result>");
        System.out.println(solution + "\n");
        System.out.println("expect(도출한 답) = " + solution + " -> actual(실제 도출되어야 하는 답) = " + expect);
        Assert.assertEquals(solution, expect);
    }

    @Test
    public void 테스트케이스1(){
        start(1, "1");
    }

    @Test
    public void 테스트케이스2(){
        start(2, "2");
    }

    @Test
    public void 테스트케이스3(){
        start(3, "4");
    }

    @Test
    public void 테스트케이스4(){
        start(4, "11");
    }

    @Test
    public void 테스트케이스5(){
        start(5, "12");
    }

    @Test
    public void 테스트케이스6(){
        start(6, "14");
    }

    @Test
    public void 테스트케이스7(){
        start(7, "21");
    }

    @Test
    public void 테스트케이스8(){
        start(8, "22");
    }

    @Test
    public void 테스트케이스9(){
        start(9, "24");
    }

    @Test
    public void 테스트케이스10(){
        start(10, "41");
    }

    @Test
    public void 테스트케이스11(){
        start(11, "42");
    }

    @Test
    public void 테스트케이스12(){
        start(12, "44");
    }

    @Test
    public void 테스트케이스13(){
        start(13, "111");
    }

    @Test
    public void 테스트케이스14(){
        start(14, "112");
    }

    @Test
    public void 테스트케이스15(){
        start(15, "114");
    }

    @Test
    public void 테스트케이스16(){
        start(16, "121");
    }

    @Test
    public void 테스트케이스17(){
        start(17, "122");
    }

    @Test
    public void 테스트케이스18() {
        start(18, "124");
    }
}

/*
정확성 테스트
테스트 1 〉	통과 (0.04ms, 75.5MB)
테스트 2 〉	통과 (0.04ms, 78MB)
테스트 3 〉	통과 (0.04ms, 73MB)
테스트 4 〉	통과 (0.04ms, 77.2MB)
테스트 5 〉	통과 (0.06ms, 79.1MB)
테스트 6 〉	통과 (0.03ms, 70.2MB)
테스트 7 〉	통과 (0.04ms, 74MB)
테스트 8 〉	통과 (0.03ms, 75.5MB)
테스트 9 〉	통과 (0.04ms, 75.5MB)
테스트 10 〉	통과 (0.04ms, 71.4MB)
테스트 11 〉	통과 (0.04ms, 77.6MB)
테스트 12 〉	통과 (0.04ms, 73.6MB)
테스트 13 〉	통과 (0.05ms, 76.3MB)
테스트 14 〉	통과 (0.04ms, 77.5MB)

효율성 테스트
테스트 1 〉	통과 (0.05ms, 51.6MB)
테스트 2 〉	통과 (0.05ms, 52MB)
테스트 3 〉	통과 (0.06ms, 52MB)
테스트 4 〉	통과 (0.05ms, 52.3MB)
테스트 5 〉	통과 (0.05ms, 53.3MB)
테스트 6 〉	통과 (0.05ms, 52MB)
 */