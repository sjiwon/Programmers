package Level1.Level1_2016;
// Level 1 : 2016년

class Solution {
    static String get_week(int day){
        switch(day%7){
            case 0: return "FRI";
            case 1: return "SAT";
            case 2: return "SUN";
            case 3: return "MON";
            case 4: return "TUE";
            case 5: return "WED";
            case 6: return "THU";
        }
        return null;
    }

    public String solution(int a, int b) {
        int [] day = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int sum = 0; // 1월 1일부터 a월 b일까지 얼마나 지났는지

        for(int i=0; i<a-1; i++)
            sum += day[i];
        sum += (b-1);

        System.out.println(sum);

        return get_week(sum);
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(3, 3));
    }
}
