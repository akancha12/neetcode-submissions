class Solution {
    public String decodeString(String s) {
        StringBuilder result = new StringBuilder();

        Stack<String> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == ']') {
                StringBuilder current = new StringBuilder();
                while (!stack.isEmpty() && !stack.peek().equals("[")) {
                    current.insert(0, stack.pop());
                }
                stack.pop();
                StringBuilder digit = new StringBuilder();
                char temp = stack.peek().charAt(0);
                while (!stack.isEmpty() && temp >= '0' && temp <= '9') {
                    digit.insert(0, stack.pop());
                    if (!stack.isEmpty())
                        temp = stack.peek().charAt(0);
                }
                int k = Integer.parseInt(digit.toString());

                StringBuilder tempResult = new StringBuilder();
                while (k > 0) {
                    tempResult.append(current.toString());
                    k--;
                }
                stack.push(tempResult.toString());
            } else {
                stack.push(c + "");
            }
        }

        while (!stack.isEmpty()) {
            result.insert(0, stack.pop());
        }
        return result.toString();
    }
}