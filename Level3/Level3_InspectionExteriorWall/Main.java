package Level3.Level3_InspectionExteriorWall;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

class Solution {

    static boolean [] visited;
    static List<Integer[]> permutationFromDist; // dist의 모든 경우의 수를 보관하는 리스트

    public int solution(int n, int[] weak, int[] dist) {
        visited = new boolean[dist.length]; // backtracking -> 순열을 통해서 dist 모든 경우의 수 찾기
        permutationFromDist = new ArrayList<>();

        int result = Integer.MAX_VALUE; // 보내야 하는 친구 수의 최솟값

        int [] buffer = new int[dist.length]; // 순열 임시 저장소
        getPermutationFromDist(dist, buffer, dist.length, dist.length, 0);
        for (Integer[] distCase : permutationFromDist) {
            for(int i=0; i<weak.length; i++){
                Deque<Integer> weakCase = getCombinationFromWeak(weak, i, n); // weak의 모든 경우의 수 (시작 지점의 변화에 의한 리스트)
                result = Math.min(result, getMinimumFriends(weakCase, distCase));
            }
        }

        return (result == Integer.MAX_VALUE) ? -1 : result; // 점검할 수 없는 경우 고려
    }

    static void getPermutationFromDist(int [] dist, int [] buffer, int n, int r, int depth){
        // dist의 모든 경우의 수 (nCr)
        if(depth == r){
            Integer [] array = new Integer[buffer.length];
            for(int i=0; i< buffer.length; i++){
                array[i] = buffer[i];
            }
            permutationFromDist.add(array); // 완성된 dist case 하나 넣어주기
            return;
        }

        for(int i=0; i<n; i++){
            if(!visited[i]){
                visited[i] = true; // visited
                buffer[depth] = dist[i];
                getPermutationFromDist(dist, buffer, n, r, depth + 1);
                visited[i] = false; // rollback (backtracking)
            }
        }
    }

    static Deque<Integer> getCombinationFromWeak(int[] weak, int i, int N){
        Deque<Integer> weakCase = new ArrayDeque<>(); // 시작지점에 따른 모든 weak 경우의 수 return
        for(int k=0; k<weak.length; k++){
            int insertValue = weak[(i + k) % weak.length];

            if(weakCase.isEmpty()){
                weakCase.offerLast(insertValue);
            } else if(weakCase.peekLast() > insertValue){ // 시계방향 기준으로 돌리기 때문에 N을 넘어선 순간 "+ N"
                weakCase.offerLast(N + insertValue);
            } else{
                weakCase.offerLast(insertValue);
            }
        }
        return weakCase;
    }

    static int getMinimumFriends(Deque<Integer> weakCase, Integer[] distCase){
        /*
        weakCase 순차적으로 점검 -> distCase내부의 dist도 순차적으로 대입해서 판단
         */
        int count = 0;

        for(Integer dist : distCase){
            if(weakCase.isEmpty()){
                break;
            }

            int coverArea = 0;
            Integer standard = weakCase.peekFirst(); // [dist]가 커버할 수 있는 영역 구하기 위한 첫번째 시작 지점
            while(true){
                if(weakCase.isEmpty()){
                    break;
                }

                Integer select = weakCase.peekFirst(); // 다음 커버 지점 선택
                if(dist >= select - standard){
                    // 커버 가능 영역
                    coverArea = select - standard;
                    weakCase.pollFirst();
                } else{
                    // 커버 불가능 (최대 이동 거리 초과)
                    break;
                }
            }

            count++;
        }

        return (weakCase.isEmpty()) ? count : Integer.MAX_VALUE;
    }
}

public class Main {
    static void start(int n, int[] weak, int[] dist, int expect){
        System.out.println("## 테스트 케이스 ##");
        System.out.println("<n>");
        System.out.println(n + "\n");
        System.out.println("<weak>");
        System.out.println(Arrays.toString(weak) + "\n");
        System.out.println("<dist>");
        System.out.println(Arrays.toString(dist) + "\n");

        int solution = new Solution().solution(n, weak, dist);
        System.out.println("<Result>");
        System.out.println(solution + "\n");
        System.out.println("expect = " + expect + " -> actual = " + solution);
        Assert.assertEquals(solution, expect);
    }

    @Test
    public void 테스트케이스1(){
        start(12, new int[]{1, 5, 6, 10}, new int[]{1, 2, 3, 4}, 2);
    }

    @Test
    public void 테스트케이스2(){
        start(12, new int[]{1, 3, 4, 9, 10}, new int[]{3, 5, 7}, 1);
    }

    @Test
    public void 테스트케이스3(){
        start(200, new int[]{0, 100}, new int[]{1, 1}, 2);
    }

    @Test
    public void 테스트케이스4(){
        start(12, new int[]{10, 0}, new int[]{1, 2}, 1);
    }

    @Test
    public void 테스트케이스5(){
        start(30, new int[]{0, 3, 11, 21}, new int[]{10, 4}, 2);
    }

    @Test
    public void 테스트케이스6(){
        start(50, new int[]{1}, new int[]{6}, 1);
    }

    @Test
    public void 테스트케이스7(){
        start(50, new int[]{1}, new int[]{6}, 1);
    }
}

/*
테스트 1 〉	통과 (0.65ms, 73.6MB)
테스트 2 〉	통과 (0.75ms, 76.8MB)
테스트 3 〉	통과 (117.62ms, 139MB)
테스트 4 〉	통과 (109.87ms, 123MB)
테스트 5 〉	통과 (3.03ms, 79.5MB)
테스트 6 〉	통과 (34.37ms, 96.1MB)
테스트 7 〉	통과 (0.37ms, 73.4MB)
테스트 8 〉	통과 (1.64ms, 77.2MB)
테스트 9 〉	통과 (1.73ms, 78.8MB)
테스트 10 〉	통과 (203.92ms, 184MB)
테스트 11 〉	통과 (200.77ms, 185MB)
테스트 12 〉	통과 (205.99ms, 201MB)
테스트 13 〉	통과 (216.31ms, 216MB)
테스트 14 〉	통과 (215.69ms, 180MB)
테스트 15 〉	통과 (218.17ms, 198MB)
테스트 16 〉	통과 (228.07ms, 205MB)
테스트 17 〉	통과 (203.16ms, 224MB)
테스트 18 〉	통과 (208.23ms, 201MB)
테스트 19 〉	통과 (183.25ms, 187MB)
테스트 20 〉	통과 (194.32ms, 172MB)
테스트 21 〉	통과 (209.42ms, 207MB)
테스트 22 〉	통과 (2.24ms, 78.9MB)
테스트 23 〉	통과 (2.23ms, 81.4MB)
테스트 24 〉	통과 (1.94ms, 73.2MB)
테스트 25 〉	통과 (62.27ms, 97.8MB)
 */
