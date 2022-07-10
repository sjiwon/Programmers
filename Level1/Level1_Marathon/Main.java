package Level1.Level1_Marathon;
// Level 1 : 완주하지 못한 선수

import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        StringBuilder sb = new StringBuilder();
        HashMap<String, Integer> hm = new HashMap<>();

        for(String name : participant){
            if(hm.containsKey(name))
                hm.put(name, hm.get(name) + 1);
            else
                hm.put(name, 1);
        }

        for(String name : completion){
            hm.put(name, hm.get(name) - 1);
        }

        Set<String> set = hm.keySet();
        Iterator<String> it = set.iterator();
        while(it.hasNext()){
            String name = it.next();
            if(hm.get(name) != 0)
                sb.append(name);
        }

        return sb.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        String [] participant1 = {"mislav", "stanko", "mislav", "ana"};
        String [] completion1 = {"stanko", "ana", "mislav"};
        System.out.println(s.solution(participant1, completion1));
    }
}