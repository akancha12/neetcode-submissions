class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];

        Stack<Integer> ngr = new Stack<>();
        for (int i=n-1; i>=0; i--) {
            if(ngr.isEmpty()) {
                result[i] = 0;
            } else {
                while(!ngr.isEmpty() && temperatures[ngr.peek()] <= temperatures[i]) {
                    ngr.pop();
                }
                if (ngr.isEmpty()) {
                    result[i] = 0;
                } else {
                    result[i] = ngr.peek() - i; 
                }
            }
            ngr.push(i);
        }
        return result;
    }
}
