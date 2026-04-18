class Solution {
    Map<Character, Character> bracesMap = new HashMap<>(){{
        put(']', '['); put('}','{'); put(')','(');
    }};
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c: s.toCharArray()) {
            if (bracesMap.containsKey(c)) {
                if(!stack.isEmpty() && stack.peek()==bracesMap.get(c)) stack.pop();
                else return false;
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
