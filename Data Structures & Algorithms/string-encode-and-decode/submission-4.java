class Solution {

    public String encode(List<String> strs) {
        // Word1, Word2 -> Word1+Word2+
        // convert evey char to int, divide by .
        // 12.22.33.44.1 then join with +
        // 12.22.33.44.1+12.22.33.44.2
        
        StringBuilder result = new StringBuilder();
        for (int strIdx = 0; strIdx < strs.size(); strIdx++) {
            String str = strs.get(strIdx);
            char[] strChars = str.toCharArray();
            for (int charIdx = 0; charIdx < strChars.length; charIdx++) {
                char c = strChars[charIdx];
                result.append((int)c);
                if (charIdx != strChars.length - 1) {
                    result.append('.');
                }
            }
            result.append('+');
        }
        return result.toString();
    }

    public List<String> decode(String str) {
       
        List<String> result = new ArrayList<>();
        StringBuilder strElement = new StringBuilder();
        StringBuilder character = new StringBuilder();
        for (char c : str.toCharArray()) {
            if ('.' == c) {
                strElement.append(charCodeStrToChar(character.toString())); 
                character.setLength(0);
            } else if ('+' == c) {
                if (!character.toString().isEmpty()) 
                strElement.append(charCodeStrToChar(character.toString()));
                character.setLength(0);
                result.add(strElement.toString());
                strElement.setLength(0);
            } else {
                character.append(c);
            }
        }
        return result;
    }

    public char charCodeStrToChar(String charCode) {
        return (char) Integer.parseInt(charCode);
    }
}
