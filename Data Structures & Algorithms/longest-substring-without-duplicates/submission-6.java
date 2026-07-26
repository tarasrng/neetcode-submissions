class Solution {
    public int lengthOfLongestSubstring(String s) {

        // "abcbdeanbn"
        // 
        // left = 0; right = l + 1
        // length = 0
        // maxLength = 0
        // iterate, add lastSeen position

        // if positions in lastSeen - then we found duplicate
        // if duplicate then left = dupl position + 1, we know there are no duplicates after
        // length = right - left
        if (s.length() <= 1) {
            return s.length();
        }

        int left = 0;
        int right = 0;
        int maxLength = 0;
        // "abcbdeanbn"
        Map<Character, Integer> lastSeen = new HashMap<>();
        while(right < s.length()) {
            int duplicatePos = lastSeen.getOrDefault(s.charAt(right), -1);
            lastSeen.put(s.charAt(right), right);
            if (duplicatePos >= left) {
                left = duplicatePos + 1;
            }
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        return maxLength;
    }
}
