class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int n : nums) set.add(n);
        int maxL = 0;
        for (Integer n : set) {
            if (!set.contains(n - 1)) {
                int l = 1;
                while (set.contains(n + l)) l++;
                maxL = Math.max(l, maxL);
            }
        }
        return maxL;
    }
}
