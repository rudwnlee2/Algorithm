class Solution {
    static public int[][] solution(int[][] arr1, int[][] arr2) {
        
        int y = arr1.length;
        int x = arr2[0].length;
        int m = arr2.length;

        int[][] answer = new int[y][x];

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                int temp = 0;
                for(int k = 0; k < m; k++) {
                    temp += arr1[i][k] * arr2[k][j];
                }
                answer[i][j] = temp;
            }
        }

        return answer;
    }
}