class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> chars = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            chars.merge(s.charAt(i), 1, Integer::sum);
        }
        for (int j = 0; j < t.length(); j++) {
            chars.merge(t.charAt(j), -1, (value, increment) -> {value += increment; return value.equals(0) ? null : value;});
        }
        return chars.isEmpty();
    }
}
