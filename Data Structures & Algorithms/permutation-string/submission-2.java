class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // "adc", "dcda"
        // put abc to array[]
        // put s1.len elements from s2 to arr
        // iterate, calculate counts
        // iterate, check matches, update matches counter
        // while matches != s1.len
        // drop left char, add right char, update counts, update matches for these two
        // 
        int winSize = s1.length();
        if (winSize > s2.length()) {
            return false;
        }
        int[] target = new int[26];
        int[] win = new int[26];

        
        for (char c : s1.toCharArray()) {
            inc(target, c);
        }

        for (int i = 0; i < s2.length(); i++) {
            inc(win, s2.charAt(i));
            if (i >= winSize) dec(win, s2.charAt(i - winSize));
            if (Arrays.equals(target, win)) {
                return true;
            }
        }
        
        return false;
    }

    private void inc(int[] arr, char key) {
        arr[key - 'a']++;
    }

    private void dec(int[] arr, char key) {
        arr[key - 'a']--;
    }

}