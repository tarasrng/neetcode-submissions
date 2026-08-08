class Solution {
    private static final Map<Character, Character> CLOSING_TO_OPENING = Map.of(')', '(', '}', '{', ']', '[');
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        boolean isValid = true;
        // Set<Characer> close = new HashSet<>();
        // close.addAll(')', '}', ']');
        //"([{}])"
        // opened put to stack, closed - remove from it, ok while type is same
        for (char c : s.toCharArray()) {
            if (CLOSING_TO_OPENING.containsKey(c)) {
                Character expectedOpeningBracket = CLOSING_TO_OPENING.get(c);
                if (stack.isEmpty() || !stack.pop().equals(expectedOpeningBracket)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
