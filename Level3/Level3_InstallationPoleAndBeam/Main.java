package Level3.Level3_InstallationPoleAndBeam;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

class Solution {

    static class InstallationInfo{
        private int x; // x좌표
        private int y; // y좌표
        private int type; // 구조물 종류 : [0 = 기둥 / 1 = 보]

        public InstallationInfo(int x, int y, int type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getType() {
            return type;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            InstallationInfo that = (InstallationInfo) o;
            return getX() == that.getX() && getY() == that.getY() && getType() == that.getType();
        }

        @Override
        public int hashCode() {
            return Objects.hash(getX(), getY(), getType());
        }
    }

    static List<InstallationInfo> process = new ArrayList<>(); // 설치 과정 저장 List

    public int[][] solution(int n, int[][] build_frame) {
        for (int[] guide : build_frame) {
            if (guide[3] == 1) {
                // 구조물 설치
                if (guide[2] == 0) {
                    // 기둥 설치
                    InstallationInfo poleInstall = new InstallationInfo(guide[0], guide[1], guide[2]);
                    if (canConstructPole(poleInstall)) {
                        process.add(poleInstall);
                    }
                } else {
                    // 보 설치
                    InstallationInfo beamInstall = new InstallationInfo(guide[0], guide[1], guide[2]);
                    if (canConstructBeam(beamInstall)) {
                        process.add(beamInstall);
                    }
                }
            } else {
                // 구조물 삭제
                InstallationInfo removeStructure = new InstallationInfo(guide[0], guide[1], guide[2]);
                process.remove(removeStructure);
                if(!canRemovalPoleOrBeam()){
                    process.add(removeStructure);
                }
            }
        }

        process.sort(new Comparator<InstallationInfo>() {
            @Override
            public int compare(InstallationInfo o1, InstallationInfo o2) {
                if(o1.getX() < o2.getX()){
                    return -1;
                } else if(o1.getX() > o2.getX()){
                    return 1;
                } else{
                    if(o1.getY() < o2.getY()){
                        return -1;
                    } else if(o1.getY() > o2.getY()){
                        return 1;
                    } else{
                        return o1.getType() - o2.getType(); // 기둥이 보보다 앞에
                    }
                }
            }
        });

        int[][] result = new int[process.size()][3];
        int index = 0;
        for(InstallationInfo info : process){
            result[index][0] = info.getX();
            result[index][1] = info.getY();
            result[index][2] = info.getType();
            index++;
        }
        return result;
    }

    static boolean isFloor(int y){
        // 1-1. 기둥 설치할 때 바닥 위에 설치되는가
        return y == 0;
    }

    static boolean isExistsBeamEitherSide(int x, int y){
        // 1-2. 기둥 설치할 때 보의 어느 한쪽 끝부분에 설치되는가
        return process.contains(new InstallationInfo(x, y, 1)) || process.contains(new InstallationInfo(x-1, y, 1));
        /*
        1. 보 왼쪽 끝에 설치
        2. 보 오른쪽 끝에 설치
         */
    }

    static boolean isStackOnAnotherPole(int x, int y){
        // 1-3. 기둥 설치할 때 다른 기둥 위에 설치되는가
        return process.contains(new InstallationInfo(x, y-1, 0));
    }

    static boolean canConstructPole(InstallationInfo pole){
        // 최종적으로 기둥 설치 조건 만족하는가
        return isFloor(pole.getY()) || isExistsBeamEitherSide(pole.getX(), pole.getY()) || isStackOnAnotherPole(pole.getX(), pole.getY());
    }

    static boolean isExistsPoleEitherSide(int x, int y){
        // 2-1. 보 설치할 때 한쪽 끝부분이 기둥 위에 있는가
        return process.contains(new InstallationInfo(x, y-1, 0)) || process.contains(new InstallationInfo(x+1, y-1, 0));
        /*
        1. 보의 왼쪽 부분 아래에 기둥 있는가
        2. 보의 오른쪽 부분 아래에 기둥 있는가
         */
    }

    static boolean isConnectedBeamBothSide(int x, int y){
        // 2-2. 보 설치할 때 양쪽 끝부분이 다른 보와 동시에 연결 되어 있는가
        return process.contains(new InstallationInfo(x-1, y, 1)) && process.contains(new InstallationInfo(x+1, y, 1));
        /*
        1. 보의 왼쪽 부분이 다른 보와 연결 되었나
        2. 보의 오른쪽 부분이 다른 보와 연결 되었나
         */
    }

    static boolean canConstructBeam(InstallationInfo beam){
        // 최종적으로 보 설치 조건 만족하는가
        return isExistsPoleEitherSide(beam.getX(), beam.getY()) || isConnectedBeamBothSide(beam.getX(), beam.getY());
    }

    static boolean canRemovalPoleOrBeam(){
        boolean canRemove = true;
        for(InstallationInfo remainStructure : process){
            // 남은 구조물들에 대해서 전부 조건 만족하는지
            if(remainStructure.getType() == 0){
                // 기둥에 대한 조건 check
                if(!canConstructPole(remainStructure)){
                    canRemove = false;
                    break;
                }
            } else{
                // 보에 대한 조건 check
                if(!canConstructBeam(remainStructure)){
                    canRemove = false;
                    break;
                }
            }
        }

        return canRemove;
    }
}

public class Main {
    static void start(int n, int[][] build_frame, int[][] expect){
        System.out.println("## 테스트 케이스 ##");
        System.out.println("<n>");
        System.out.println(n + "\n");
        System.out.println("<build_frame>");
        System.out.println(Arrays.deepToString(build_frame) + "\n");

        int[][] solution = new Solution().solution(5, build_frame);
        System.out.println("<Result>");
        System.out.println(Arrays.deepToString(solution) + "\n");
        System.out.println("expect = " + Arrays.deepToString(expect) + " -> actual = " + Arrays.deepToString(solution) + "\n");
        Assert.assertArrayEquals(solution, expect);
    }

    @Test
    public void 테스트케이스1(){
        start(5,
                new int[][]{
                        {1, 0, 0, 1},
                        {1, 1, 1, 1},
                        {2, 1, 0, 1},
                        {2, 2, 1, 1},
                        {5, 0, 0 ,1},
                        {5, 1, 0, 1},
                        {4, 2, 1, 1},
                        {3, 2, 1, 1}
                }, new int[][]{
                        {1, 0, 0},
                        {1, 1, 1},
                        {2, 1, 0},
                        {2, 2, 1},
                        {3, 2, 1},
                        {4, 2, 1},
                        {5, 0, 0},
                        {5, 1, 0}
                }
        );

        Solution.process.clear();
    }

    @Test
    public void 테스트케이스2(){
        start(5,
                new int[][]{
                        {0, 0, 0, 1},
                        {2, 0, 0, 1},
                        {4, 0, 0, 1},
                        {0, 1, 1, 1},
                        {1, 1, 1, 1},
                        {2, 1, 1, 1},
                        {3, 1, 1, 1},
                        {2, 0, 0, 0},
                        {1, 1, 1, 0},
                        {2, 2, 0, 1}
                }, new int[][]{
                        {0, 0, 0},
                        {0, 1, 1},
                        {1, 1, 1},
                        {2, 1, 1},
                        {3, 1, 1},
                        {4, 0, 0}
                }
        );

        Solution.process.clear();
    }
}

// Solution3.process.clear() -> 테스트간 static List인 Process의 element 초기화

/*
테스트 1 〉	통과 (0.80ms, 83.1MB)
테스트 2 〉	통과 (0.98ms, 75.1MB)
테스트 3 〉	통과 (0.93ms, 78.5MB)
테스트 4 〉	통과 (1.00ms, 74.6MB)
테스트 5 〉	통과 (1.04ms, 74.9MB)
테스트 6 〉	통과 (2.07ms, 73.5MB)
테스트 7 〉	통과 (0.52ms, 74.9MB)
테스트 8 〉	통과 (0.65ms, 78.5MB)
테스트 9 〉	통과 (0.80ms, 80MB)
테스트 10 〉	통과 (11.22ms, 72.6MB)
테스트 11 〉	통과 (27.87ms, 94.3MB)
테스트 12 〉	통과 (6.58ms, 84MB)
테스트 13 〉	통과 (27.34ms, 100MB)
테스트 14 〉	통과 (7.75ms, 83.6MB)
테스트 15 〉	통과 (24.84ms, 82.4MB)
테스트 16 〉	통과 (7.29ms, 93.7MB)
테스트 17 〉	통과 (22.39ms, 82.3MB)
테스트 18 〉	통과 (41.43ms, 76.9MB)
테스트 19 〉	통과 (44.76ms, 90.6MB)
테스트 20 〉	통과 (43.07ms, 85.4MB)
테스트 21 〉	통과 (46.86ms, 79.7MB)
테스트 22 〉	통과 (36.15ms, 103MB)
테스트 23 〉	통과 (41.92ms, 89.6MB)
 */

