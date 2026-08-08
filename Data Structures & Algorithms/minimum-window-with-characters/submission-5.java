class Solution {
    public String minWindow(String s, String t) {
        // "OUZODYXAZV", t = "XYZ" -> "YXAZ"
        // put t to map char -> freq
        // left = 0; right = t.size - 1;
        //put window chars to freqs map

        // check if matches (window freq >= t freq)
        // if no - expand right
        // if yes - try shrinking left - recheck freqs
        // optimizion - check only letter that changes
        // continue increasing right, repeat everything
        // until right < s.size -1

        //ABCDEDFAFE AFE 
        //windowFreq map, tFreqMap

        if (s.length() < t.length() || s.isEmpty()) {
            return "";
        }

        int left = 0;
        int right = t.length() - 1;
        int totalFreq = t.length();;
        int windowTotalFreq = 0;
        String minSubstring = "";
        Map<Character, Integer> tFreqs = new HashMap<>();
        Map<Character, Integer> windowFreqs = new HashMap<>();
        for (char c : t.toCharArray()) {
            tFreqs.merge(c, 1, Integer::sum);
        }
        for (int i = left; i <= right; i++) {
            windowFreqs.merge(s.charAt(i), 1, Integer::sum);
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
