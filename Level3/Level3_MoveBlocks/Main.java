package Level3.Level3_MoveBlocks;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.Queue;

class Solution2 {

    static class Position { // (x, y) 좌표
        private int x;
        private int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Position position = (Position) o;
            return getX() == position.getX() && getY() == position.getY();
        }

        @Override
        public int hashCode() {
            return Objects.hash(getX(), getY());
        }
    }

    static class PositionInfo{
        private Position left;
        private Position right;

        public PositionInfo(Position left, Position right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            PositionInfo that = (PositionInfo) o;
            return Objects.equals(left, that.left) && Objects.equals(right, that.right);
        }

        @Override
        public int hashCode() {
            return Objects.hash(left, right);
        }
    }

    static class Robot { // 로봇의 좌표 : (leftX, leftY), (rightX, rightY)
        private Position left;
        private Position right;
        private int time; // (PositionLeft, PositionRight)까지 걸린 시간

        public Robot(Position left, Position right, int time) {
            this.left = left;
            this.right = right;
            this.time = time;
        }

        public Position getLeft() {
            return left;
        }

        public Position getRight() {
            return right;
        }

        public int getTime(){
            return time;
        }
    }

    static Position targetPosition; // 도달 목표 좌표

    static int totalTime = 0; // 이동하는데 걸린 시간
    static int[][] map;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public int solution(int[][] board) {
        map = board;
        // 목표 좌표 설정
        targetPosition = new Position(board.length - 1, board.length - 1);
        // 초기 로봇 좌표 설정
        Robot robot = new Robot(new Position(0, 0), new Position(0, 1), 0);

        return bfs(robot);
    }

    static int bfs(Robot startRobot){
        Queue<Robot> queue = new LinkedList<>();
        Queue<PositionInfo> positions = new LinkedList<>();
        queue.offer(startRobot);

        while(!queue.isEmpty()){
            Robot moveRobot = queue.poll();

            if(isReachedTarget(moveRobot)){
                return moveRobot.getTime();
            }

            List<List<Position>> possiblePositions = getPossiblePositions(moveRobot);

            for (List<Position> possiblePosition : possiblePositions) {
                Position leftPosition = possiblePosition.get(0);
                Position rightPosition = possiblePosition.get(1);

                if(!positions.contains(new PositionInfo(leftPosition, rightPosition))){
                    queue.offer(new Robot(leftPosition, rightPosition, moveRobot.getTime() + 1));
                    positions.offer(new PositionInfo(leftPosition, rightPosition));
                }
            }
        }

        return 0;
    }

    static List<List<Position>> getPossiblePositions(Robot robot){
        // robot의 현재 위치로부터 이동 가능한 위치 return (동서남북 check + 회전 4방향 check)
        List<List<Position>> possibleList = new ArrayList<>();

        Position leftPosition = robot.getLeft();
        int leftX = leftPosition.getX();
        int leftY = leftPosition.getY();

        Position rightPosition = robot.getRight();
        int rightX = rightPosition.getX();
        int rightY = rightPosition.getY();

        // 동서남북 가능한 위치 저장
        for(int i=0; i<4; i++){
            int nextLeftX = leftX + dx[i];
            int nextLeftY = leftY + dy[i];
            int nextRightX = rightX + dx[i];
            int nextRightY = rightY + dy[i];

            if(isRange(nextLeftX, nextLeftY) && isRange(nextRightX, nextRightY)) {
                if (map[nextLeftX][nextLeftY] == 0 && map[nextRightX][nextRightY] == 0) {
                    List<Position> list = new ArrayList<>();
                    list.add(new Position(nextLeftX, nextLeftY));
                    list.add(new Position(nextRightX, nextRightY));
                    possibleList.add(list);
                }
            }
        }

        if(leftX == rightX) { // 수평일 경우 회전 위치 저장
            // 1. Up 방향 회전
            if(canRotateUp(leftX, leftY, rightX, rightY)){
                // 1-1. [RobotRight] 기준 Up
                Position leftMoveUp = new Position(rightX - 1, rightY);
                // 1-2. [RobotLeft] 기준 up
                Position rightMoveUp = new Position(leftX - 1, leftY);

                List<Position> changeLeft = new ArrayList<>();
                changeLeft.add(leftMoveUp); // Left (좌표변화 O)
                changeLeft.add(new Position(rightX, rightY)); // Right (좌표변화 X)
                possibleList.add(changeLeft);

                List<Position> changeRight = new ArrayList<>();
                changeRight.add(new Position(leftX, leftY)); // Left (좌표변화 X)
                changeRight.add(rightMoveUp); // Right (좌표변화 O)
                possibleList.add(changeRight);
            }

            // 2. Down 방향 회전
            if(canRotateDown(leftX, leftY, rightX, rightY)){
                // 2-1. [RobotRight] 기준 Down
                Position leftMoveDown = new Position(rightX + 1, rightY);
                // 2-2. [RobotLeft] 기준 Down
                Position rightMoveDown = new Position(leftX + 1, leftY);

                List<Position> changeLeft = new ArrayList<>();
                changeLeft.add(leftMoveDown); // Left (좌표변화 O)
                changeLeft.add(new Position(rightX, rightY)); // Right (좌표변화 X)
                possibleList.add(changeLeft);

                List<Position> changeRight = new ArrayList<>();
                changeRight.add(new Position(leftX, leftY)); // Left (좌표변화 X)
                changeRight.add(rightMoveDown); // Right (좌표변화 O)
                possibleList.add(changeRight);
            }

        } else if(leftY == rightY) { // 수직일 경우 회전 위치 저장
            // 1. Left 방향 회전
            if(canRotateLeft(leftX, leftY, rightX, rightY)) {
                // 1-1. [RobotRight] 기준 Left
                Position leftMoveLeft = new Position(rightX, rightY - 1);
                // 1-2. [RobotLeft] 기준 Left
                Position rightMoveLeft = new Position(leftX, leftY - 1);

                List<Position> changeLeft = new ArrayList<>();
                changeLeft.add(leftMoveLeft);
                changeLeft.add(new Position(rightX, rightY));
                possibleList.add(changeLeft);

                List<Position> changeRight = new ArrayList<>();
                changeRight.add(new Position(leftX, leftY));
                changeRight.add(rightMoveLeft);
                possibleList.add(changeRight);
            }

            // 2. Right 방향 회전
            if(canRotateRight(leftX, leftY, rightX, rightY)) {
                // 2-1. South 기준 Right
                Position northMoveRight = new Position(robot.getRight().getX(), robot.getRight().getY() + 1);
                // 2-2. North 기준 Right
                Position southMoveRight = new Position(robot.getLeft().getX(), robot.getLeft().getY() + 1);

                List<Position> changeLeft = new ArrayList<>();
                changeLeft.add(northMoveRight);
                changeLeft.add(new Position(rightX, rightY));
                possibleList.add(changeLeft);

                List<Position> changeRight = new ArrayList<>();
                changeRight.add(new Position(leftX, leftY));
                changeRight.add(southMoveRight);
                possibleList.add(changeRight);
            }
        }

        return possibleList;
    }

    static boolean canRotateUp(int leftX, int leftY, int rightX, int rightY){
        int nextLeftX = leftX - 1;
        int nextRightX = rightX - 1;

        if(isRange(nextLeftX, leftY) && isRange(nextRightX, rightY)){
            return map[nextLeftX][leftY] == 0 && map[nextRightX][rightY] == 0;
        }

        return false;
    }

    static boolean canRotateDown(int leftX, int leftY, int rightX, int rightY){
        int nextLeftX = leftX + 1;
        int nextRightX = rightX + 1;

        if(isRange(nextLeftX, leftY) && isRange(nextRightX, rightY)){
            return map[nextLeftX][leftY] == 0 && map[nextRightX][rightY] == 0;
        }

        return false;
    }

    static boolean canRotateLeft(int leftX, int leftY, int rightX, int rightY){
        int nextLeftY = leftY - 1;
        int nextRightY = rightY - 1;

        if(isRange(leftX, nextLeftY) && isRange(rightX, nextRightY)){
            return map[leftX][nextLeftY] == 0 && map[rightX][nextRightY] == 0;
        }

        return false;
    }

    static boolean canRotateRight(int leftX, int leftY, int rightX, int rightY){
        int nextLeftY = leftY + 1;
        int nextRightY = rightY + 1;

        if(isRange(leftX, nextLeftY) && isRange(rightX, nextRightY)){
            return map[leftX][nextLeftY] == 0 && map[rightX][nextRightY] == 0;
        }

        return false;
    }

    static boolean isRange(int x, int y){
        return 0 <= x && x < map.length && 0 <= y && y < map.length;
    }

    static boolean isReachedTarget(Robot robot){
        return robot.getLeft().equals(targetPosition) || robot.getRight().equals(targetPosition);
    }
}

public class Main {
    static void start(int[][] board, int expect){
        System.out.println("## 테스트 케이스 ##");
        System.out.println("<board>");
        System.out.println(Arrays.deepToString(board));

        int solution = new Solution2().solution(board);
        System.out.println("<Result>");
        System.out.println(solution + "\n");
        System.out.println("expect(도출한 답) = " + solution + " -> actual(실제 도출되어야 하는 답) = " + expect);
        Assert.assertEquals(solution, expect);
    }

    @Test
    public void 테스트케이스1(){
        start(
                new int[][]{
                        {0, 0, 0, 1, 1},
                        {0, 0, 0, 1, 0},
                        {0, 1, 0, 1, 1},
                        {1, 1, 0, 0, 1},
                        {0, 0, 0, 0, 0}
                },
                7
        );
    }
}

/*
테스트 1 〉	통과 (1.60ms, 75.4MB)
테스트 2 〉	통과 (1.96ms, 72.4MB)
테스트 3 〉	통과 (2.28ms, 73.8MB)
테스트 4 〉	통과 (4.15ms, 80.2MB)
테스트 5 〉	통과 (3.20ms, 74.3MB)
테스트 6 〉	통과 (4.16ms, 74.7MB)
테스트 7 〉	통과 (10.51ms, 79.3MB)
테스트 8 〉	통과 (14.02ms, 82.6MB)
테스트 9 〉	통과 (14.15ms, 98.7MB)
테스트 10 〉	통과 (13.15ms, 79.5MB)
테스트 11 〉	통과 (6.99ms, 74.4MB)
테스트 12 〉	통과 (9.12ms, 77.1MB)
테스트 13 〉	통과 (7244.91ms, 104MB)
테스트 14 〉	통과 (2848.90ms, 89.5MB)
 */
