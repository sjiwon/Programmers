package Level1.Level1_MatrixAdd;
// Level 1 : 행렬의 덧셈

class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int [][] result = new int[arr1.length][arr1[0].length];

        for(int i=0; i<arr1.length; i++){
            for(int j=0; j<arr1[i].length; j++)
                result[i][j] = arr1[i][j] + arr2[i][j];
        }

        return result;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
