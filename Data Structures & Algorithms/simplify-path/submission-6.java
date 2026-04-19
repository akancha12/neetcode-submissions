class Solution {
    public String simplifyPath(String path) {
        StringBuilder result = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        Stack<String> stack = new Stack<>();
        int dotCount = 0;
        path = path + '/';
        for (char c : path.toCharArray()) {
            if (c == '/') {
                if (temp.toString().equals("..")) {
                    if (!stack.isEmpty())
                        stack.pop();
                } else if (temp.length() > 0 && !temp.toString().equals(".")) {
                    stack.push(temp.toString());
                }
                temp = new StringBuilder();
            } else {
                temp.append(c);
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