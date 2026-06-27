class Solution {
    private final char PREFIX = '#';
    public String encode(List<String> strs) {
        // 12n, x
        // 3#12n1#x
        
        StringBuilder result = new StringBuilder();
        for (String str : strs) {
            result.append(str.length()).append(PREFIX).append(str);
        }
        return result.toString();
    }

    public List<String> decode(String str) {
       // 3#12n1#x
        List<String> result = new ArrayList<>();
        StringBuilder lengthStr = new StringBuilder();
        int idx = 0;
        int length = 0;
        
        while (idx < str.length()) {
            while (str.charAt(idx) != PREFIX) {
                lengthStr.append(str.charAt(idx++));
            } 
            length = Integer.parseInt(lengthStr.toString());
            result.add(str.substring(idx + 1, idx + length + 1));
            idx += length + 1;
            lengthStr.setLength(0);
        }
        return result;
    }
}
