package Level1.Level1_FindKimInSeoul;
// Level 1 : 서울에서 김서방 찾기

class Solution {
    public String solution(String[] seoul) {
        StringBuilder sb = new StringBuilder("김서방은 에 있다");

        int index = 0;
        for(String w : seoul){
            if(w.equals("Kim"))
                break;
            index++;
        }

        sb.insert(5, index);

        return sb.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        String [] s1 = {"Jane", "Kim"};

        Solution s = new Solution();

        System.out.println(s.solution(s1));
    }
}
