package Level1.Level1_Lotto;
// Level 1 : 로또의 최고 순위와 최저 순위

/*
1등 = 6개 일치
2등 = 5개 일치
3등 = 4개 일치
4등 = 3개 일치
5등 = 2개 일치
6등 = 1개 or 0개
 */

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int [] result = new int[2];

        int zerocount = 0; // 0 개수
        int correct = 0; // 맞은 개수

        for (int lotto : lottos) {
            if (lotto == 0)
                zerocount++;
        }

        for (int lotto : lottos) {
            for (int win_num : win_nums) {
                if (lotto == win_num)
                    correct++;
            }
        }

        result[0] = rank(correct+zerocount);
        result[1] = rank(correct);

        return result;
    }
    static int rank(int num){
        switch(num){
            case 6:
                return 1;
            case 5:
                return 2;
            case 4:
                return 3 ;
            case 3:
                return 4;
            case 2:
                return 5;
            default:
                return 6;
        }
    }
}