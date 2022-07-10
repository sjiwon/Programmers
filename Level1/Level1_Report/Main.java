package Level1.Level1_Report;
// Level1 : 신고 결과 받기
import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int [] count = new int[id_list.length]; // 각 유저에 대한 최종 결과 메일 수

        HashMap<String, Set<String>> hm = new HashMap<>();

        for(String id : id_list)
            hm.put(id, new HashSet<>());
        // id_list 를 HashMap에 넣고 초기화 (해당 ID가 신고한 유저는 현재 X)

        for(String r : report){
            String [] list = r.split(" "); // list[0]이 list[1]을 신고
            hm.get(list[0]).add(list[1]);
        }

        HashMap<String, Integer> result = new HashMap<>();
        // 신고 당한 사람, 신고 횟수 저장

        for(String s : report) { // 신고당한 사람들 HashMap 초기화
            String [] list = s.split(" ");
            result.put(list[1], 0);
        }

        for(String id : hm.keySet()){ // 유저 ID
            for(String r_id : hm.get(id)){ // 유저가 신고한 ID 목록 (Set - 중복 X)
                for(String name : result.keySet()){ // 신고당한 사람들 KeySet
                    if(r_id.equals(name))
                        result.put(name, result.get(name) + 1);
                }
            }
        }

        for(int i=0; i<id_list.length; i++){
            for(String r_id : hm.get(id_list[i])){ // 유저 ID에 대한 신고 목록
                if(result.get(r_id) >= k) // 신고 횟수가 K번 이상이면 메일 발송
                    count[i]++;
            }
        }

        return count;
    }
}

public class Main {
    public static void main(String[] args) {
        String [] id_list1 = {"muzi", "frodo", "apeach", "neo"};
        String [] report1 = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};

        String [] id_list2 = {"con", "ryan"};
        String [] report2 = {"ryan con", "ryan con", "ryan con", "ryan con"};
        Solution s = new Solution();

        int [] count = s.solution(id_list1, report1, 2);
        for(int n : count)
            System.out.print(n + " ");
        System.out.println();
        int [] count2 = s.solution(id_list2, report2, 3);
        for(int n : count2)
            System.out.print(n + " ");
    }
}
