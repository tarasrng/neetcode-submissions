class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
//        1. sort
//        -2,-2 -1,-1,1,1,0,1,2,3
     

// 2. i = 0; 
// skip if i == i -1

// find j and k so j+k = -i
// j = i+1; k = end
// if sum < target and j < k
// j++
// if sum > target and j < k
// k--
// if (sum == target) -> 
// match -> add triplet
//     j++; k--
//     while (j < k && nums[j] == nums[j-1]) j++    // slide past dup values
//     while (j < k && nums[k] == nums[k+1]) k--    // slide past dup values
// complexity: n ^ 2

        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        // [-1,0,1,2,-1,-4] -> [-2,0,2] [-1,0,1]
        //[-4,-1,-1,0,1,2]
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int target = -nums[i];
                int sum = nums[j] + nums[k];
                if (sum == target) {
                    result.add(List.of(nums[i], nums[j], nums[k]));
                    j++; k--;
                    while (j < k && nums[j] == nums[j - 1]) j++;
                    while (j < k && nums[k] == nums[k + 1]) k--;
                } else if (sum < target) j++;
                else if (sum > target) k--;
            }
        }
 
        return result;
    }
}
