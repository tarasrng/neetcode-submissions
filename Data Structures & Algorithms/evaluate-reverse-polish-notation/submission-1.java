class Solution {
    public int evalRPN(String[] tokens) {
        //todo add function
        Set<String>operators = Set.of("+", "-", "*", "/");
        Deque<Integer> operands = new ArrayDeque<>();
        for (String token : tokens) {
            if (!operators.contains(token)) {
                operands.push(Integer.valueOf(token));
            } else {
                int a = operands.pop();
                int b = operands.pop();
                switch(token) {
                    case "+": operands.push(b + a); break;
                    case "-": operands.push(b - a); break;
                    case "*": operands.push(b * a); break;
                    case "/": operands.push(b / a); break;
                    default: throw new RuntimeException("Wrong operator");
                }
            }
        }
        return operands.pop();
    }
}
