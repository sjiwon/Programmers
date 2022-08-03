package Level3.Level3_ChuseokTraffic;

import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/*
SimpleDateFormat + Date 풀이
 */

class Solution {
    public int solution(String[] lines) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss.SSS"); // 시간 추출 format
        int maxRequest = 0;

        for (int i = 0; i < lines.length; i++) {
            int subRequest = 0;
            String[] standard = lines[i].split(" "); // [2016-09-15, 01:00:04.001, 2.0s]
            Date standardEndDate = format.parse(standard[1]); // 01:00:04.001
            long standardEndTime = standardEndDate.getTime(); // 기준 종료 시간 [시간을 ms로 표기 (1970-01-01 ~ standardEndTime까지)]

            for (int j = i; j < lines.length; j++) {
                String[] compare = lines[j].split(" "); // [2016-09-15, 01:00:07.000, 2s]
                Date compareEndDate = format.parse(compare[1]); // 01:00:07.000
                double processS = Double.parseDouble(compare[2].substring(0, compare[2].length() - 1)); // 비교 날짜 처리 시간 [s] (2s)

                long compardStartTime = (long) (compareEndDate.getTime() - (processS * 1000) + 1); // 비교 시작 날짜 (getTime -> [ms])

                if (standardEndTime + 1000 > compardStartTime) { // 1000ms = 1s안에 request가 들어왔다면
                    subRequest += 1;
                }
            }

            maxRequest = Math.max(maxRequest, subRequest);
        }

        return maxRequest;
    }
}

public class Main {
    static void start(String[] lines, int expect) throws ParseException {
        System.out.println("## 테스트 케이스 ##");
        System.out.println("<Lines>");
        System.out.println(Arrays.deepToString(lines));

        int solution = new Solution().solution(lines);
        System.out.println("<Result>");
        System.out.println(solution + "\n");
        System.out.println("expect(도출한 답) = " + solution + " -> actual(실제 도출되어야 하는 답) = " + expect);
        Assert.assertEquals(solution, expect);
    }

    @Test
    public void 테스트케이스1() throws ParseException {
        start(
                new String[]{
                        "2016-09-15 00:00:00.000 3s"
                },
                1
        );
    }

    @Test
    public void 테스트케이스2() throws ParseException {
        start(
                new String[]{
                        "2016-09-15 23:59:59.999 0.001s"
                },
                1
        );
    }

    @Test
    public void 테스트케이스3() throws ParseException {
        start(
                new String[]{
                        "2016-09-15 01:00:04.001 2.0s",
                        "2016-09-15 01:00:07.000 2s"
                },
                1
        );
    }

    @Test
    public void 테스트케이스4() throws ParseException {
        start(
                new String[]{
                        "2016-09-15 01:00:04.002 2.0s",
                        "2016-09-15 01:00:07.000 2s"
                },
                2
        );
    }

    @Test
    public void 테스트케이스5() throws ParseException {
        start(
                new String[]{
                        "2016-09-15 20:59:57.421 0.351s",
                        "2016-09-15 20:59:58.233 1.181s",
                        "2016-09-15 20:59:58.299 0.8s",
                        "2016-09-15 20:59:58.688 1.041s",
                        "2016-09-15 20:59:59.591 1.412s",
                        "2016-09-15 21:00:00.464 1.466s",
                        "2016-09-15 21:00:00.741 1.581s",
                        "2016-09-15 21:00:00.748 2.31s",
                        "2016-09-15 21:00:00.966 0.381s",
                        "2016-09-15 21:00:02.066 2.62s"
                },
                7
        );
    }

    @Test
    public void 테스트케이스6() throws ParseException {
        start(
                new String[]{
                        "2016-09-15 00:00:00.000 2.3s",
                        "2016-09-15 23:59:59.999 0.1s"
                },
                1
        );
    }
}

/*
테스트 1 〉	통과 (30.14ms, 80.3MB)
테스트 2 〉	통과 (672.32ms, 391MB)
테스트 3 〉	통과 (675.99ms, 405MB)
테스트 4 〉	통과 (34.40ms, 85.6MB)
테스트 5 〉	통과 (77.60ms, 91.6MB)
테스트 6 〉	통과 (67.79ms, 90.8MB)
테스트 7 〉	통과 (730.40ms, 400MB)
테스트 8 〉	통과 (628.21ms, 390MB)
테스트 9 〉	통과 (79.84ms, 94.6MB)
테스트 10 〉	통과 (31.46ms, 80.5MB)
테스트 11 〉	통과 (35.36ms, 91.2MB)
테스트 12 〉	통과 (680.35ms, 403MB)
테스트 13 〉	통과 (68.07ms, 104MB)
테스트 14 〉	통과 (29.36ms, 77.4MB)
테스트 15 〉	통과 (29.41ms, 90.9MB)
테스트 16 〉	통과 (25.94ms, 87.5MB)
테스트 17 〉	통과 (35.70ms, 72.6MB)
테스트 18 〉	통과 (1730.38ms, 406MB)
테스트 19 〉	통과 (1790.35ms, 394MB)
테스트 20 〉	통과 (1812.69ms, 385MB)
테스트 21 〉	통과 (34.88ms, 88.5MB)
테스트 22 〉	통과 (28.40ms, 86.6MB)
 */