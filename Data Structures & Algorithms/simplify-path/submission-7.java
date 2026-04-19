class Solution {
    public String simplifyPath(String path) {
        StringBuilder result = new StringBuilder();
        Stack<String> stack = new Stack<>();
        int dotCount = 0;
        for (String s : path.split("/")) {
            if (s.length() == 0 || s.equals(".")) continue;
            if (s.equals("..")) {
                if (!stack.isEmpty()) stack.pop();
            } else {
                stack.push(s);
            }
        }
        while (!stack.isEmpty()) {
            result.insert(0, stack.pop());
            result.insert(0, '/');
        }
        if (result.length() == 0)
            result.append('/');
        return result.toString();
    }
}