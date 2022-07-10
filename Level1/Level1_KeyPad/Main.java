package Level1.Level1_KeyPad;
// Level 1 : 키패드 누르기

class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        int left_h = 10, right_h = 12;
        int left_c, right_c; // left ~ center 거리, right ~ center 거리
        for (int number : numbers) {
            if (number == 1 || number == 4 || number == 7) {
                sb.append("L");
                left_h = number;
            }
            else if (number == 3 || number == 6 || number == 9) {
                sb.append("R");
                right_h = number;
            }
            else { // center (2, 5, 8, 0)
                left_c = get_length(left_h, number);
                right_c = get_length(right_h, number);

                if(left_c < right_c){
                    sb.append("L");
                    left_h = number;
                }
                else if(right_c < left_c){
                    sb.append("R");
                    right_h = number;
                }
                else{
                    if(hand.equals("right")){
                        sb.append("R");
                        right_h = number;
                    }
                    else{
                        sb.append("L");
                        left_h = number;
                    }
                }
            }
        }
        return sb.toString();
    }

    static int get_length(int start, int number){
        start = (start == 0) ? 11 : start; // 0이면 11로
        number = (number == 0) ? 11 : number; // 0이면 11로

        int x = Math.abs(start-1)/3; // 양쪽 숫자 x좌표
        int y = Math.abs(start-1)%3; // 양쪽 숫자 y좌표
        int center_x = number/3; // 중앙 숫자 x좌표
        int center_y = 1; // 중앙 숫자 y좌표 = 항상 1

        return Math.abs(x-center_x) + Math.abs(y-center_y);
    }
}
