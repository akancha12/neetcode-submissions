class Solution {
    public String decodeString(String s) {
        StringBuilder result = new StringBuilder();

        Stack<String> stack = new Stack<>();
        StringBuilder current = new StringBuilder();
        StringBuilder number = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                if (number.length() > 0) {
                    stack.push(number.toString());
                    number = new StringBuilder();
                }
                current.append(c);
            } else if (c >= '0' && c <= '9') {
                if (current.length() > 0) {
                    stack.push(current.toString());
                    current = new StringBuilder();
                }
                number.append(c);
            } else if (c == '[') {
                if (current.length() > 0)
                    stack.push(current.toString());
                if (number.length() > 0)
                    stack.push(number.toString());
                current = new StringBuilder();
                number = new StringBuilder();
                stack.push(c + "");
            } else {
                if (current.length() > 0)
                    stack.push(current.toString());
                if (number.length() > 0)
                    stack.push(number.toString());
                current = new StringBuilder();
                number = new StringBuilder();
                while (!stack.isEmpty() && !stack.peek().equals("[")) {
                    current.insert(0, stack.pop());
                }
                stack.pop();
                int k = Integer.parseInt(stack.pop());
                StringBuilder temp = new StringBuilder();
                while (k > 0) {
                    temp.append(current.toString());
                    k--;
                }
                stack.push(temp.toString());
                current = new StringBuilder();
                number = new StringBuilder();
            }
        }

        while (!stack.isEmpty()) {
            result.insert(0, stack.pop());
        }
        if (current.length() > 0)
            result.append(current.toString());
        return result.toString();
    }
}