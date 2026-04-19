class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int nsr[] = new int[n];
        int nsl[] = new int[n];

        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<n; i++) {
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            if(stack.isEmpty()) nsl[i] = 0;
            else nsl[i] = stack.peek() + 1;
            stack.push(i);
        }

        stack = new Stack<>();
        for (int i=n-1; i>=0; i--) {
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            if(stack.isEmpty()) nsr[i] = n-1;
            else nsr[i] = stack.peek() - 1;
            stack.push(i);
        }
        int result = 0;
        for (int i=0; i<n; i++) {
            result = Math.max(result, (nsr[i]-nsl[i] +1)* heights[i]);
        }
        return result;
    }
}
