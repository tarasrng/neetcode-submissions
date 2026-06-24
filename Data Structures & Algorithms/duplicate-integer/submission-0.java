class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> uniqueNums = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (uniqueNums.contains(nums[i])) return true;
            uniqueNums.add(nums[i]);
        }
        return false;
    }
}