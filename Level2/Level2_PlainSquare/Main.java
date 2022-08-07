package Level2.Level2_PlainSquare;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;

/*
세로 = 12, 가로 = 8
(0, 0) - (3, 2) >> 4 (제거 개수)
(3, 2) - (6, 4) >> 4 (제거 개수)
(6, 4) - (9, 6) >> 4 (제거 개수)
(9, 6) - (12, 8) >> 4 (제거 개수)
    -> 4 = 3 + 2 - 1

세로 = 12, 가로 = 10
(0, 0) - (6, 5) >> 10 (제거 개수)
(6, 5) - (12, 10) >> 10 (제거 개수)
    -> 10 = 6 + 5 - 1

세로 = 15, 가로 = 6
(0, 0) - (5, 2) >> 6 (제거 개수)
(5, 2) - (10, 4) >> 6 (제거 개수)
(10, 4) - (15, 6) >> 6 (제거 개수)
    -> 6 = 5 + 2 - 1
 */

class Solution {
    public long solution(int w, int h) {
        // example[w = 6, h = 15]

        // w, h의 최대 공약수 (cycle) [3]
        BigInteger gcd = BigInteger.valueOf(w).gcd(BigInteger.valueOf(h));

        // 사각형 만나는 꼭짓점
        BigInteger divideW = BigInteger.valueOf(w).divide(gcd); // [2]
        BigInteger divideH = BigInteger.valueOf(h).divide(gcd); // [5]

        // 제거 개수 (cycle에 곱해서 전체 개수에서 빼주기) >> [6 * 3]
        long removeCount = Long.parseLong(String.valueOf(divideW.add(divideH).abs())) - 1; // [6]

        // (6 * 15) - (6 * 3)
        return ((long) w * h) - (removeCount * Long.parseLong(String.valueOf(gcd)));
    }
}

public class Main {
    static void start(int w, int h, long expect){
        System.out.println("## 테스트 케이스 ##");
        System.out.println("<W & H>");
        System.out.println("W = " + w);
        System.out.println("H = " + h);

        long solution = new Solution().solution(w, h);
        System.out.println("\n<Result>");
        System.out.println(solution + "\n");
        System.out.println("expect(도출한 답) = " + solution + " -> actual(실제 도출되어야 하는 답) = " + expect);
        Assert.assertEquals(solution, expect);
    }

    @Test
    public void 테스트케이스1(){
        start(8, 12, 80);
    }

    @Test
    public void 테스트케이스2(){
        start(10, 12, 100);
    }

    @Test
    public void 테스트케이스3(){
        start(6, 15, 72);
    }
}
