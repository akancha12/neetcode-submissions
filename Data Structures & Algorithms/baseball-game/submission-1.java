class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> scores = new Stack<>();
        for (String s : operations) {
            Integer score = convertInteger(s);
            if (score != null) {
                scores.push(score);
            } else if (s.equals("+")) {
                int s1 = scores.pop();
                int s2 = scores.pop();
                scores.push(s2);
                scores.push(s1);
                scores.push(s1 + s2);
            } else if (s.equals("D")) {
                int s1 = scores.peek();
                scores.push(2*s1);
            } else {
                int s1 = scores.pop();
            }
        }
        int result = 0;
        while(!scores.isEmpty()) {
            result+= scores.pop();
        }
        return result;
    }
    public Integer convertInteger(String s) {
        try {
            int score = Integer.parseInt(s);
            return score;
        } catch (NumberFormatException e) {
        }
        return null;
    }
}