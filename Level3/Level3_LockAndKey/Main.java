package Level3.Level3_LockAndKey;

import org.junit.Assert;
import org.junit.Test;

class Solution {

    static int [][] copyMap;

    public boolean solution(int[][] key, int[][] lock) {
        // key 오른쪽 맨밑 모서리 기준으로 key를 lock의 각 칸마다 대입 (회전 -> 0 90 180 270)
        int [][] map = generateMap(lock);
        return tryUnlock(key, map, lock.length);
    }

    static int [][] generateMap(int [][] lock){
        // lock + map전부 수용할 수 있는 map 생성 (lock, key길이 고려해서 만들지 않고 그냥 lock*3 크기 배열 생성)
        int [][] map = new int[lock.length*3][lock.length*3];

        for(int i=0; i<lock.length; i++){
            for(int j=0; j<lock[i].length; j++){
                map[i + lock.length][j + lock.length] = lock[i][j];
            }
        }

        return map;
    }

    static int [][] copyMap(int [][] map){
        // (r, c)에 key 넣을 때마다 결과값 저장할 copyMap
        int [][] copy = new int[map.length][map.length];

        for(int i=0; i<map.length; i++){
            for(int j=0; j<map[i].length; j++){
                copy[i][j] = map[i][j];
            }
        }

        return copy;
    }

    static boolean tryUnlock(int [][] key, int [][] map, int lockLength){
        for(int i=0; i<4; i++){ // 90도씩 회전하면서 lock부분 체크 (lock은 map 중앙에 위치)

            for(int r=lockLength; r<lockLength*2 + key.length; r++){
                for(int c=lockLength; c<lockLength*2 + key.length; c++){
                    copyMap = copyMap(map);
                    // (r, c)에 key 넣어보기
                    insertKey(copyMap, key, r, c);

                    if(checkAllClear(copyMap, lockLength)){
                        // lock의 모든 칸이 1이라면 unlock clear
                        return true;
                    }
                }
            }

            key = rotateKey(key); // 시계방향으로 90도 회전
        }

        return false; // 경우의수 -> 4*N*N을 다 해봐도 unlock 불가
    }

    static void insertKey(int [][] copyMap, int [][] key, int startX, int startY){
        /*
        (startX, startY)는 Lock의 각 칸의 좌표
        -> (startX, startY)에 key의 오른쪽 맨밑 모서리를 맞춰서 끼워넣기
         */
        int row = 0;
        for(int i=startX-key.length+1; i<=startX; i++){
            int column = 0;
            for(int j=startY-key.length+1; j<=startY; j++){
                copyMap[i][j] += key[row][column];
                column += 1;
            }
            row += 1;
        }
    }

    static int[][] rotateKey(int [][] key){
        // key 90도 회전시키기 (시계방향)
        int [][] new_key = new int[key.length][key.length];

        for(int i=0; i<key.length; i++){
            for(int j=0; j<key[i].length; j++){
                new_key[j][key.length - 1 - i] = key[i][j];
            }
        }

        return new_key;
    }

    static boolean checkAllClear(int [][] map, int lockLength){
        // lock의 모든 칸이 1이 되었는지 확인
        for(int i=lockLength; i<lockLength*2; i++){
            for(int j=lockLength; j<lockLength*2; j++){
                if(map[i][j] != 1){
                    return false;
                }
            }
        }
        return true;
    }
}

public class Main {

    static void print(int [][] m){
        for (int[] ints : m) {
            for (int anInt : ints) {
                System.out.print(anInt);
            }
            System.out.println();
        }
        System.out.println();
    }

    static void start(int[][] key, int[][] lock, boolean expect){
        System.out.println("## 테스트 케이스 ##");
        System.out.println("<Key>");
        print(key);
        System.out.println("<Lock>");
        print(lock);

        boolean solution = new Solution().solution(key, lock);
        System.out.println("expect = " + expect + " -> actual = " + solution + "\n");
        Assert.assertTrue(solution);
    }

    @Test
    public void 테스트케이스(){
        start(
                new int[][]{
                        {0, 0, 0},
                        {1, 0, 0},
                        {0, 1, 1}
                },
                new int[][]{
                        {1, 1, 1},
                        {1, 1, 0},
                        {1, 0, 1}
                },
                true
        );
    }
}

/*
테스트 1 〉	통과 (0.48ms, 73.5MB)
테스트 2 〉	통과 (0.10ms, 79.5MB)
테스트 3 〉	통과 (7.44ms, 74.5MB)
테스트 4 〉	통과 (0.04ms, 84.1MB)
테스트 5 〉	통과 (11.61ms, 83.9MB)
테스트 6 〉	통과 (15.55ms, 102MB)
테스트 7 〉	통과 (16.92ms, 92.8MB)
테스트 8 〉	통과 (26.52ms, 89.4MB)
테스트 9 〉	통과 (34.35ms, 103MB)
테스트 10 〉	통과 (46.14ms, 114MB)
테스트 11 〉	통과 (58.90ms, 123MB)
테스트 12 〉	통과 (0.04ms, 74.3MB)
테스트 13 〉	통과 (4.52ms, 78.6MB)
테스트 14 〉	통과 (1.87ms, 75.8MB)
테스트 15 〉	통과 (3.64ms, 76.8MB)
테스트 16 〉	통과 (14.57ms, 81.7MB)
테스트 17 〉	통과 (2.56ms, 76.4MB)
테스트 18 〉	통과 (22.57ms, 85.1MB)
테스트 19 〉	통과 (1.33ms, 75MB)
테스트 20 〉	통과 (40.63ms, 108MB)
테스트 21 〉	통과 (13.89ms, 83.8MB)
테스트 22 〉	통과 (18.17ms, 91.3MB)
테스트 23 〉	통과 (2.21ms, 74.1MB)
테스트 24 〉	통과 (3.57ms, 79.9MB)
테스트 25 〉	통과 (78.81ms, 107MB)
테스트 26 〉	통과 (35.08ms, 100MB)
테스트 27 〉	통과 (61.41ms, 134MB)
테스트 28 〉	통과 (10.47ms, 91.6MB)
테스트 29 〉	통과 (5.05ms, 76.7MB)
테스트 30 〉	통과 (15.20ms, 90.7MB)
테스트 31 〉	통과 (34.54ms, 95.9MB)
테스트 32 〉	통과 (47.13ms, 125MB)
테스트 33 〉	통과 (15.80ms, 85.4MB)
테스트 34 〉	통과 (0.19ms, 72.5MB)
테스트 35 〉	통과 (1.56ms, 78MB)
테스트 36 〉	통과 (3.77ms, 85.4MB)
테스트 37 〉	통과 (1.99ms, 73.4MB)
테스트 38 〉	통과 (1.41ms, 72.6MB)
 */
