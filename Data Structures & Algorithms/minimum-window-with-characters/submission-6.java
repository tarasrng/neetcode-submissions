class Solution {
    public String minWindow(String s, String t) {
        if (s.isEmpty()) return "";

        int left = 0;
        int right = - 1;
        int totalFreq = t.length();
        int windowTotalFreq = 0;
        String minSubstring = "";
        Map<Character, Integer> tFreqs = new HashMap<>();
        Map<Character, Integer> windowFreqs = new HashMap<>();
        for (char c : t.toCharArray()) {
            tFreqs.merge(c, 1, Integer::sum);
        }

        for (Map.Entry<Character, Integer> e : tFreqs.entrySet()) {
            windowTotalFreq += Math.min(windowFreqs.getOrDefault(e.getKey(), 0), e.getValue());
        }
        boolean shrinked = false;
        while (right < s.length()) {
            shrinked = false;
            boolean matches = windowTotalFreq >= totalFreq;
            if (matches) {
                if (minSubstring.isEmpty() || right - left + 1 < minSubstring.length()) {
                    minSubstring = s.substring(left, right + 1);
                }
                //try shrinking left + recheck
                Character leftChar = s.charAt(left);
                Integer leftFreq = tFreqs.getOrDefault(leftChar, 0);
                if (leftFreq < windowFreqs.get(leftChar)) {
                    left++;
                    shrinked = true;
                    windowFreqs.put(leftChar, Math.max(windowFreqs.get(leftChar) - 1, 0));
                }                
            }
             if (!shrinked) {
                right++;
                if (right < s.length()) {
                    Character rightChar = s.charAt(right);
                    if (windowFreqs.getOrDefault(rightChar, 0) < tFreqs.getOrDefault(rightChar, 0)) {
                        windowTotalFreq++;
                    }
                    windowFreqs.merge(rightChar, 1, Integer::sum);
                }
            }
        }
        return minSubstring;
    }
}
