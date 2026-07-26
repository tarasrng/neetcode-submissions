class Solution {
    public int lengthOfLongestSubstring(String s) {

        // "abcbdeanbn"
        // 
        // int left, right
        // a hashmap letter, list[positions] (add all lettes from s)

        // left = 0; right = l + 1
        // length = 0
        // maxLength = 0
        // if positions in hashmap are in range left - right - then we found duplicate
        // if duplicate left = dupl position + 1, we know there are no duplicates after
        // length = right - left
        if (s.length() <= 1) {
            return s.length();
        }

        int left = 0;
        int right = left + 1;
        int maxLength = 0;
        // "abcbdeanbn"
        Map<Character, TreeSet<Integer>> charToPos = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            charToPos.computeIfAbsent(s.charAt(i), k -> new TreeSet<>()).add(i);
        }
        while(right < s.length()) {
            TreeSet<Integer> positions = charToPos.get(s.charAt(right));
            int duplicatePos = -1;
            if (positions != null) {
                duplicatePos = positions.ceiling(left);
            }
            if (duplicatePos > -1 && duplicatePos < right) {
                left = duplicatePos + 1;
            }
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        return maxLength;
    }
}
