class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numToPos = new HashMap<>();
        
        for (int i = 1; i < nums.length; i++) {
            numToPos.put(nums[i - 1], i - 1);
            int diff = target - nums[i];
            if (numToPos.containsKey(diff)) {
                return new int[]{numToPos.get(diff), i};
            }
        }
        return new int[]{};
    }
}
