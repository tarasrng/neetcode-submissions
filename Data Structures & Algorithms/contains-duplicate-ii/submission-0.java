class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // [1,2,3,1], k = 3
        Map<Integer, Integer> numToPos = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (numToPos.containsKey(nums[i]) && i - numToPos.get(nums[i]) <= k) {
                return true;
            }
            numToPos.put(nums[i], i);
        }
        return false;
    }
}