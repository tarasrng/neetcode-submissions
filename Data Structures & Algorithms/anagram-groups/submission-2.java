class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<Integer>> frequencies = new ArrayList<>();
        Map<String, List<String>> anagramGroups = new HashMap<>();

        for (String s: strs) {
            String key = Arrays.toString(createFrequenciesArray(s));
            anagramGroups.computeIfAbsent(key, (k) -> new ArrayList()).add(s);
        }
        
        return new ArrayList<>(anagramGroups.values());
    }

    public int[] createFrequenciesArray(String word) {
        int[] freq = new int[26];
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }
        return freq;  
    }
}
