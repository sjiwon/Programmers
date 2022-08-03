package Level2.Level2_ColoringBook;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
picture[x][y] == 0인 부분은 컬러가 아니므로 영역에 포함 X
>> picture[x][y] != 0인 부분들에 대해서 check

이 문제는 static variable을 반드시 Solution Function 내부에서 초기화해야 맞는 문제?
-> ??????????????????????????????????????????????????????????????????????????????????????????????????????????????
 */

class Solution {

    static class Point{
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    static int M;
    static int N;
    static int areaCount;
    static int maxArea;
    static int[] dx;
    static int[] dy;
    static boolean[][] visited;

    public int[] solution(int m, int n, int[][] picture) {
        M = m;
        N = n;
        areaCount = 0;
        maxArea = 0;
        dx = new int[]{0, 0, 1, -1};
        dy = new int[]{1, -1, 0, 0};
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && picture[i][j] != 0) {
                    bfs(picture, i, j);
                    areaCount++;
                }
            }
        }

        return new int[]{areaCount, maxArea};
    }

    static void bfs(int[][] picture, int x, int y){
        int areaWH = 1;

        Queue<Point> queue = new LinkedList<>();
        visited[x][y] = true;
        queue.offer(new Point(x, y));

        while(!queue.isEmpty()){
            Point poll = queue.poll();

            for(int i=0; i<4; i++){
                int nextX = poll.getX() + dx[i];
                int nextY = poll.getY() + dy[i];

                if (isRange(nextX, nextY) && isSameArea(picture, poll, nextX, nextY) && !visited[nextX][nextY]) {
                    areaWH++;
                    visited[nextX][nextY] = true;
                    queue.offer(new Point(nextX, nextY));
                }
            }
        }

        maxArea = Math.max(maxArea, areaWH);
    }

    static boolean isSameArea(int[][] picture, Point p, int x, int y){
        return picture[p.getX()][p.getY()] == picture[x][y];
    }

    static boolean isRange(int x, int y){
        return 0 <= x && x < M && 0 <= y && y < N;
    }
}

public class Main {
    static void start(int m, int n, int[][] picture, int[] expect){
        System.out.println("## 테스트 케이스 ##");
        System.out.println("<m & n>");
        System.out.println("m = " + m + " / n = " + n);

        int[] solution = new Solution().solution(m, n, picture);
        System.out.println("\n<Result>");
        System.out.println(Arrays.toString(solution) + "\n");
        System.out.println("expect(도출한 답) = " + Arrays.toString(solution) + " -> actual(실제 도출되어야 하는 답) = " + Arrays.toString(expect));
        Assert.assertArrayEquals(solution, expect);
    }

    @Test
    public void 테스트케이스1(){
        start(
                13, 16,
                new int[][]{
                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0},
                        {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0},
                        {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0},
                        {0, 1, 1, 1, 1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 1, 0},
                        {0, 1, 1, 1, 2, 1, 2, 1, 1, 2, 1, 2, 1, 1, 1, 0},
                        {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                        {0, 1, 3, 3, 3, 1, 1, 1, 1, 1, 1, 3, 3, 3, 1, 0},
                        {0, 1, 1, 1, 1, 1, 2, 1, 1, 2, 1, 1, 1, 1, 1, 0},
                        {0, 0, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 1, 1, 0, 0},
                        {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0},
                        {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0}
                },
                new int[]{12, 120}
        );
    }

    @Test
    public void 테스트케이스2(){
        start(
                6, 4,
                new int[][]{
                        {1, 1, 1, 0},
                        {1, 2, 2, 0},
                        {1, 0, 0, 1},
                        {0, 0, 0, 1},
                        {0, 0, 0, 3},
                        {0, 0, 0, 3},
                },
                new int[]{4, 5}
        );
    }
}
