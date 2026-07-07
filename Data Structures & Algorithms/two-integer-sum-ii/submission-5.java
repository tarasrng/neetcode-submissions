class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // numbers=[-8,-3,0,2,4,10] -> -1
        // left = 1, right = 1
        // right ++
        // if right >= len - 1 or sum > target-> left ++, right = left+1
        // 
        int left = 0;
        int right = 1;
        int sum = numbers[left] + numbers[right];
        while (sum != target) {
            if (sum > target || right >= numbers.length - 1) {
                left++;
                right = left + 1;
            } else {
                right++;
            }
            sum = numbers[left] + numbers[right];
        }
        return new int[]{++left, ++right};
    }
}
