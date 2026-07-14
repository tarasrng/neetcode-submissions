class Solution {
    public int maxArea(int[] heights) {
        // left = 0; right = len - 1;
        // calc area set max;
        // move smaller side
        // area = (right - left) * smaller

    
        int left = 0;
        int right = heights.length - 1;
        int maxArea = 0;
        while (left != right) {
            maxArea = Math.max(maxArea, area(left, right, heights));
            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    private int area(int left, int right, int[] heights) {
        return (right - left) * Math.min(heights[left], heights[right]);
    }
}
