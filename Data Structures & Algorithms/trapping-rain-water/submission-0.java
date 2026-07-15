class Solution {
    public int trap(int[] height) {
        // calcualate highest left and right for each
        // iterate left to right and right to left
    
        // for each area is min (suff, pref) - high (check minus)
        // example: 
        // 0,2,0,3,1,0,1,3,2,1
        // 0,0,2,2,3,3,3,3,3,3
        // 3,3,3,3,3,3,3,2,1,0
        // 0,0,2,0,2,3,2,0,0,0 = 9

        int left = 0; 
        int right = height.length - 1;
        int[] maxPref = new int[height.length];
        int[] maxSuff = new int[height.length];

        int maxLeft = 0;
        int maxRight = 0;
        while (right >= 0) {
            if (left == 0) {
                maxPref[left] = 0;
                maxSuff[right] = 0;
            } else {
                maxLeft = Math.max(maxLeft, height[left - 1]);
                maxPref[left] = maxLeft;
                maxRight = Math.max(maxRight, height[right + 1]);
                maxSuff[right] = maxRight;
            }
            right--;
            left++;
        }
        int area = 0;
        for (int i = 0; i < height.length; i++) {
            area += Math.max(0, Math.min(maxSuff[i], maxPref[i]) - height[i]);
        }

        return area;
    }
}
