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
        int i = 0;
        int j = i + 1;
        int k = nums.length - 1;
        // [-1,0,1,2,-1,-4] -> [-2,0,2] [-1,0,1]
        //[-4,-1,-1,0,1,2]
        while (i < nums.length - 2) {
            if (j >= k || (i > 0 && nums[i] == nums[i - 1])) {
                i++;
                while (i < nums.length - 2 && nums[i] == nums[i - 1]) {
                    i++;
                }
                if (i >= nums.length - 2) {
                    continue;
                }
                j = i + 1;
                k = nums.length - 1;
            }
            int target = -nums[i];
            int sum = nums[j] + nums[k];
            if (sum == target) {
                result.add(List.of(nums[i], nums[j], nums[k]));
                j++;
                k--;
                while (j < k && nums[j] == nums[j - 1]) j++;
                while (j < k && nums[k] == nums[k + 1]) k--;
            } else if (sum < target && j < k) {
                j++;
            }
            else if (sum > target && j < k) {
                k--;
            }
        }
        return result;
    }
}
