package Level1.Level1_FindMod1;
// Level 1 : 나머지가 1이 되는 수 찾기

class Solution {
    public int solution(int n) {
        int result = 0;

        for(int i=1; i<n; i++){
            if(n%i == 1){
                result = i;
                break;
            }
        }

        return result;
    }
}
