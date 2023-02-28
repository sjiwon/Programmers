package Level3.Level3_BestAlbum;

// 장르별로 2개씩
// -> 1. 속한 노래들이 가장 많이 재생된 장르부터
// -> 2. 장르 내부적으로 많이 재생된 노래부터
// -> 3. [1, 2] 조건이 모두 동일하면 고유 번호가 가장 낮은 노래부터

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        // 장르 - [장르 인덱스 - 재생 횟수]
        Map<String, Map<Integer, Integer>> map = new HashMap<>();

        for(int i=0; i<genres.length; i++) {
            map.put(genres[i], new HashMap<>());
        }

        for(int i=0; i<genres.length; i++) {
            String genre = genres[i];
            int index = i;
            int play = plays[i];

            // 장르 인덱스 - 재생 횟수
            Map<Integer, Integer> subInfo = map.get(genre);
            subInfo.put(index, play);
        }

        // 장르별 재생 횟수 기준 내림차순 정렬 list1
        List<String> list1 = new ArrayList<>(map.keySet());
        list1.sort((o1, o2) -> {
            return Integer.compare(getSum(map.get(o2)), getSum(map.get(o1)));
        });

        // 최종 결과 배열
        List<Integer> resultList = new ArrayList<>();

        for(String genre : list1) { // 재생 횟수 기준 정렬된 장르에 대해서
            Map<Integer, Integer> subMap = map.get(genre); // 장르에 대한 고유 번호 - 재생 횟수 맵
            // 장르 내부적으로 재생 횟수 - 고유 번호에 대한 내림차순/오름차순 정렬 list2
            List<Integer> list2 = new ArrayList<>(subMap.keySet());
            list2.sort((o1, o2) -> {
                // 1. 재생 횟수 기준 정렬
                if(subMap.get(o1) > subMap.get(o2)) {
                    return -1;
                } else if(subMap.get(o1) < subMap.get(o2)) {
                    return 1;
                } else {
                    // 2. 고유번호에 대한 정렬
                    return Integer.compare(o1, o2);
                }
            });

            int count = 0; // 장르별로 최대 2개
            for(Integer value : list2) {
                if(count == 2) {
                    break;
                }
                resultList.add(value); // 고유번호 넣기
                count++; // 카운트 증가
            }
        }

        int[] result = new int[resultList.size()];
        int index = 0;
        for(Integer value : resultList) {
            result[index] = value;
            index++;
        }
        return result;
    }

    private int getSum(Map<Integer, Integer> subMap) {
        int result = 0;

        for(Integer value : subMap.keySet()) {
            result += subMap.get(value);
        }

        return result;
    }
}

public class Main {
    static void start(String[] genres, int[] plays, int[] expect){
        int[] solution = new Solution().solution(genres, plays);

        StringBuilder result = new StringBuilder();
        result.append("## 테스트 케이스 ##").append("\n")
                .append("[Parameter -> String[] genres]").append("\n")
                .append("-> ").append(Arrays.toString(genres)).append("\n\n")
                .append("[Parameter -> int[] plays]").append("\n")
                .append("-> ").append(Arrays.toString(plays)).append("\n\n")
                .append("[Result]").append("\n")
                .append("-> ").append(Arrays.toString(solution)).append("\n\n")
                .append("======================================\n")
                .append("예상 정답 = ").append(Arrays.toString(solution)).append("\n")
                .append("실제 정답 = ").append(Arrays.toString(expect));

        System.out.println(result);
        Assertions.assertArrayEquals(solution, expect);
    }

    @Test
    public void 테스트케이스1(){
        start(
                new String[] {"classic", "pop", "classic", "classic", "pop"},
                new int[] {500, 600, 150, 800, 2500},
                new int[] {4, 1, 3, 0}
        );
    }
}