class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // [1,2,2,3,3,3], k = 2
        // [2,3]
        // create a hash map of frequencies
        // {1:1, 2:2, 3:3} iterate
        // create a list of frequencies as index and nums as value
        // [[],[1],[2,3],[],[],[],[]] <- iterate backwards
        // 
        int[] topK = new int[k];
        Map<Integer, Integer> freqMap = new HashMap<>();
        List<Integer>[] freqArr = new ArrayList[nums.length + 1];
        for(int num : nums) {
            freqMap.merge(num, 1, Integer::sum);
        }
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            Integer num = entry.getKey();
            Integer freq = entry.getValue();
            if (freqArr[freq] == null) freqArr[freq] = new ArrayList<>();
            freqArr[freq].add(num);
        }
        for (int i = freqArr.length - 1; i >= 0 && k > 0; i--) {
            List<Integer> numsGroup = freqArr[i];
            if (numsGroup != null) {
                for (Integer numInGroup : numsGroup) {
                    topK[--k] = numInGroup;
                    if (k <= 0) break;
                }
            }
        }
        return topK;
    }
}
