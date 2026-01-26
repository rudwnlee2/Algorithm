class Solution {
    public String solution(int a, int b) {
        int[] arr = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] result = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        
        int temp = 0;
        for (int i = 0; i < a - 1; i++) {
            temp += arr[i];
        }
        
        temp += b - 1;
        return result[temp % 7];
    }
}