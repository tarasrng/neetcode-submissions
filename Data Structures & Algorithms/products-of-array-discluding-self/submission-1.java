class Solution {
    public int[] productExceptSelf(int[] nums) {
        // [1,2,4,6]
        // pref
        // [1,1,2,8]
        // suff
        // [48,24,6,1]
        int[] products = new int[nums.length];
        int[] pref = new int[nums.length];
        int[] suff = new int[nums.length];
        pref[0] = 1;
        suff[nums.length - 1] = 1;
        for (int i = 1; i < nums.length; i++) {
            pref[i] = pref[i - 1] * nums[i - 1];
            suff[nums.length - 1 - i] = suff[nums.length - i] * nums[nums.length - i];
        }

        for (int i = 0; i < nums.length; i++) {
            products[i] = pref[i] * suff[i];
        }

        return products;
    }
}  
