package Level2.Level2_OpenChating;

import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        HashMap<String, String> id_name = new HashMap<>();
        // 유저 아이디 - 닉네임

        for(String r : record){
            String [] line = r.split(" ");

            String state = line[0];
            String id = line[1];

            if(state.equals("Enter")){
                id_name.put(id, line[2]);
            }
            else if(state.equals("Change")){
                id_name.put(id, line[2]);
            }
        }

        ArrayList<String> list = new ArrayList<>();
        for(String r : record){
            String [] line = r.split(" ");

            String state = line[0];
            String id = line[1];

            if(state.equals("Enter")){
                String name = id_name.get(id);
                String sentence = name + "님이 들어왔습니다.";
                list.add(sentence);
            }
            else if(state.equals("Leave")){
                String name = id_name.get(id);
                String sentence = name + "님이 나갔습니다.";
                list.add(sentence);
            }
        }

        String [] result = new String[list.size()];
        for(int i=0; i<list.size(); i++){
            result[i] = list.get(i);
        }

        return result;
    }
}

public class Main{
    public static void main(String[] args) {
        String [] record = {
                "Enter uid1234 Muzi",
                "Enter uid4567 Prodo",
                "Leave uid1234",
                "Enter uid1234 Prodo",
                "Change uid4567 Ryan"
        };

        String [] result = new Solution().solution(record);

        for(String s : result){
            System.out.println(s);
        }
    }
}