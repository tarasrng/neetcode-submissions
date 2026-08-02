class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // "adc", "dcda"
        // put ab to map
        // iterate s2, and return true if s1.len subsequent chars exsist in abc (consider duplicates)

        Map<Character, Integer> s1Counts = new HashMap<>();
        Map<Character, Integer> s2Counts = new HashMap<>();

        int left = 0;
        int right = 0;
        // "adc", "lecaabee"
        for (char s : s1.toCharArray()) {
            s1Counts.merge(s, 1, Integer::sum);
        }
        // a -> 1, b -> 1, c -> 1
        while (right < s2.length()) {
            char rightChar = s2.charAt(right);
            s2Counts.merge(rightChar, 1, Integer::sum);
            Integer s1Count = s1Counts.get(rightChar);
            Integer s2Count = s2Counts.getOrDefault(rightChar, 1);
            if (s1Count == null || s2Count > s1Count) {
                s2Counts.compute(s2.charAt(left), (k, v) -> (v != null && v > 0) ? v - 1 : 0);
                left++;
                if (left > right) {
                    right = left;
                } else {
                    s2Counts.compute(s2.charAt(right), (k, v) -> (v != null && v > 0) ? v - 1 : 0);
                }
            } else {
                right++;
            }
            if (right - left == s1.length()) {
                return true;
            }

        }
        return false;
    }
}