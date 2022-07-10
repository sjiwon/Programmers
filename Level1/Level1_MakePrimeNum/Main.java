package Level1.Level1_MakePrimeNum;
// Level 1 : 소수 만들기

class Solution {
    public int solution(int[] nums) {
        int p_count = 0; // 소수 개수

        for(int i=0; i<nums.length-2; i++){
            for(int j=i+1; j<nums.length-1; j++){
                for(int k=j+1; k<nums.length; k++){
                    int sum = nums[i] + nums[j] + nums[k];
                    if(prime(sum))
                        p_count++;
                }
            }
        }

        return p_count;
    }

    static boolean prime(int num){
        if (num == 1)
            return false;
        else if (num == 2)
            return true;
        else{
            for(int i=2; i<num; i++){
                if ((num % i) == 0)
                    return false;
            }
        }
        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int [] nums = {1, 2, 3, 4};
        int [] nums2 = {1, 2, 7, 6, 4};
        System.out.println(s.solution(nums));
        System.out.println(s.solution(nums2));
        for(int i=1; i<=20; i++){
            if(Solution.prime(i))
                System.out.print(i + " ");
        }
    }
}