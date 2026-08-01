class Solution {
    public int characterReplacement(String s, int k) {
        
        // XYXYXYXXXX
        // k = 2
        // at every step add letter to couts map and calc maxFreq
        // 1122334567
        // left = 0, right = 0
        // rigth++ until len - maxFreq <=k
        // else - left++, remove 1 letter count
        

        //s="AAAA"
        //k=0
        int maxFreq = 0;
        int maxLen = 0;
        Map<Character, Integer> counts = new HashMap<>();
        int left = 0;
        int right = 0;

        while (right < s.length()) {
            char lChar = s.charAt(left);
            char rChar = s.charAt(right);
            counts.merge(rChar, 1, Integer::sum);
            maxFreq = Math.max(maxFreq, counts.get(rChar));
            int len = right - left + 1 ;
            if (len - maxFreq > k) {
                counts.merge(lChar, -1, Integer::sum);
                left++;
            } else {
                maxLen = Math.max(maxLen, len);
            }
            right++;
        }
        return maxLen;
    }
}
