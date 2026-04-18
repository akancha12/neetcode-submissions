class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> scores = new Stack<>();
        for (String s : operations) {
            if (s.equals("+")) {
                int s1 = scores.pop();
                int newScore = scores.peek() + s1;
                scores.push(s1);
                scores.push(newScore);
            } else if (s.equals("D")) {
                scores.push(2*scores.peek());
            } else if (s.equals("C")) {
                int s1 = scores.pop();
            } else {
                scores.push(Integer.parseInt(s));
            }
        }
        int result = 0;
        while(!scores.isEmpty()) {
            result+= scores.pop();
        }
        return result;
    }
}