package Level4.Level4_MuziLive;

import java.util.*;

class Solution {

    static class Food{
        private int idx;
        private int time;

        public Food(int idx, int time) {
            this.idx = idx;
            this.time = time;
        }

        public int getIdx() {
            return idx;
        }

        public int getTime() {
            return time;
        }

        @Override
        public String toString() {
            return "Food{" +
                    "idx=" + idx +
                    ", time=" + time +
                    '}';
        }
    }

    public int solution(int[] food_times, long k) {
        // food의 한 줄 사이즈만큼 한번에 먹기 :: time별로 오름차순 정렬
        List<Food> table = new LinkedList<>();

        for(int i=0; i<food_times.length; i++){
            table.add(new Food((i + 1), food_times[i]));
        }

        table.sort((o1, o2) -> Integer.compare(o1.getTime(), o2.getTime())); // time순으로 오름차순 정렬

        int size = 0; // 이전 Cycle까지 처리한 row 수
        long time = 0L; // 이전 Cycle까지 먹방한 총 시간

        while(!table.isEmpty()){
            if(table.get(0).getTime() <= size){
                /*
                다음에 확인할 idx가 이전 단계랑 동일한 time을 가지고 있으면 삭제
                -> 이전 단계에서 한번에 block 단위로 계산해서 중복 제거를 위해서 remove
                 */
                table.remove(table.get(0));
                continue;
            }

            if(time == k){
                // 먹방한 시간이 k(네트워크 장애 발생 시간)과 동일하면 먹방 잠시 중단
                break;
            }

            int currentSize = table.get(0).getTime() - size; // 현재 Cycle에서 처리할 Block의 세로길이
            long currentTime = (long) currentSize * table.size();

            if(k < time + currentTime){
                /*
                현재 Cycle에서 모든 instance에 대해서 먹방을 정상적으로 수행할 수 없는 경우
                -> 그러면 현재 Cycle에서 먹방할 수 있는 시간 = k - time
                 */

                table.sort((o1, o2) -> Integer.compare(o1.getIdx(), o2.getIdx())); // idx에 대한 오름차순 정렬
                long validTime = k - time;
                int afterNetworkFailIdx = (int)(validTime % table.size());

                return table.get(afterNetworkFailIdx).getIdx();
            }

            /*
            현재 Cycle까지 정상적으로 먹방 다 수행할 수 있는지
            -> 전체 기준 : k가 "time + currentInfo[2]"보다 크다면 현재 Cycle은 정상적으로 수행 가능
             */

            table.remove(table.get(0)); // get(0)번째 음식은 더이상 먹을 일이 없음
            size += currentSize;
            time += currentTime;
        }

        table.sort((o1, o2) -> Integer.compare(o1.getIdx(), o2.getIdx()));
        return table.isEmpty() ? -1 : table.get(0).getIdx();
    }
}

public class MuziLive {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[]{3, 1, 2}, 5));
        System.out.println(s.solution(new int[]{1, 1, 1, 1}, 4));
        System.out.println(s.solution(new int[]{1, 3, 3, 5, 6, 6}, 20));
    }
}