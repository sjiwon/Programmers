package Level1.Level1_MinimumRectangle;
// Level 1 : 최소 직사각형

import java.util.*;
class Solution {
    public int solution(int[][] sizes) {
        for(int [] arr : sizes){
            if(arr[0] < arr[1]){
                // 모든 명함을 가로로 길게, 세로로 짧게 만들기
                int tmp = arr[0];
                arr[0] = arr[1];
                arr[1] = tmp;
            }
        }

        int [] width = new int[sizes.length];
        int [] height = new int[sizes.length];

        for(int i=0; i<sizes.length; i++){
            width[i] = sizes[i][0];
            height[i] = sizes[i][1];
        } // 각 명함의 가로, 세로 저장 배열

        Arrays.sort(width);
        Arrays.sort(height);

        // 각 명함의 가로 중 max값, 세로 중 max값 안에는 모든 명함이 포함될 수 있다
        return width[sizes.length-1] * height[sizes.length-1];
    }
}
