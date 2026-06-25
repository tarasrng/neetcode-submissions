class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //["act","pots","tops","cat","stop","hat"]
//[1 0 1 0 0 1], [1 0 1 0 0 1],
// {[1 0 1 0 0 1] : 0,1}
        List<List<Integer>> frequencies = new ArrayList<>();
        Map<List<Integer>, List<Integer>> anagramGroups = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            List<Integer> key = createFrequenciesArray(strs[i]);
            anagramGroups.computeIfAbsent(key, (k) -> new ArrayList()).add(i);
        }
        List<List<String>> result = new ArrayList<>();
        for (List<Integer> indices : anagramGroups.values()) {
            List<String> group = new ArrayList<>();
            for (int idx : indices) {
                group.add(strs[idx]);
            }
            result.add(group);
        }
        return result;
    }

    public List<Integer> createFrequenciesArray(String word) {
        List<Integer> freqArray = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            freqArray.add(0);
        }
        for (int i = 0; i < word.length(); i++) {
            int pos = word.charAt(i) - 'a';
            freqArray.set(pos, freqArray.get(pos) + 1);
        }
        return freqArray;  
    }
}
