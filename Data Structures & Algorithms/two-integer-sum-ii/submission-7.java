class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // numbers=[2,3,4] -> 6
        // left = 1, right = n - 1
        // if left + right > target -> right--
        // else (left + right < target)
        // left ++
        // 
        int left = 0;
        int right = numbers.length - 1;
        int sum = numbers[left] + numbers[right];
        while (sum != target) {
            if (sum > target) {
                right--;
            } else {
                left++;
            }
            sum = numbers[left] + numbers[right];
        }
        return new int[]{++left, ++right};
    }
}
