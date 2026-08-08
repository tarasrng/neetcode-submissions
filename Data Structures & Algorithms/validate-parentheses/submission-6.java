class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        Set<Character> brackets = Set.of('(', '{', '[');
        Map<Character, Character> closingBrackets = Map.of(')', '(', '}', '{', ']', '[');
        boolean isValid = true;

        // Set<Characer> close = new HashSet<>();
        // close.addAll(')', '}', ']');
        //"([{}])"
        // opened put to stack, closed - remove from it, ok while type is same
        for (Character c : s.toCharArray()) {
            if (brackets.contains(c)) {
                stack.push(c);
            } else {
                Character expectedOpeningBracket = closingBrackets.get(c);
                if (stack.isEmpty() || stack.pop() != expectedOpeningBracket) {
                    isValid = false;
                }
            }
        }
        return isValid && stack.isEmpty();
    }
}
