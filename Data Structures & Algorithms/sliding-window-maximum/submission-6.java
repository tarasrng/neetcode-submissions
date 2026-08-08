class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // l = 0, r = 0;
        // (int r = 0; r < n; r++)
        // add to heap -> log (k)
        // r ++
        // if (r - l + 1 == k) -> ret top from heap , 
        // --> DO not remove l from heap as its o(n), instead  have a map of left items, if pick returns one of them remove it from map (allow dups) - and try again 
        // --> l++
        //

        // n log n
        
        int l = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        Map<Integer, Integer> leftCounts = new HashMap<>();

        int[] result = new int[nums.length - k + 1];
        int resIndex = 0;
        for (int r = 0; r < nums.length; r++) {
            heap.add(nums[r]);
            if (r - l + 1 == k) {
                Integer max;
                do {
                    max = heap.peek();
                    if (leftCounts.getOrDefault(max, 0) > 0) {
                        heap.poll();
                        leftCounts.merge(max, -1, Integer::sum);
                        max = heap.peek();
                    }
                } while (leftCounts.getOrDefault(max, 0) > 0); 
                result[resIndex++] = max;
                leftCounts.merge(nums[l], 1, Integer::sum);
                l++;
            }
        }
        return result;
    }
}
