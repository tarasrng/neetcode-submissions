class Solution {
    private static final char DELIM = '#';
    public String encode(List<String> strs) {
        // 12n, x
        // 3#12n1#x
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length()).append(DELIM).append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
       // 3#12n1#x
        List<String> result = new ArrayList<>();
        int idx = 0;
        int length = 0;
        
        while (idx < str.length()) {
            int prefIdx = str.indexOf(DELIM, idx);
            length = Integer.parseInt(str.substring(idx, prefIdx));
            result.add(str.substring(prefIdx + 1, prefIdx + length + 1));
            idx = prefIdx + length + 1;
        }
        return result;
    }
}
