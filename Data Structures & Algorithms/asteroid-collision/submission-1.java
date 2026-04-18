class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> currentState = new Stack<>();
        for (int asteroid : asteroids) {
            if (asteroid >= 0 || currentState.isEmpty() || isPositive(currentState.peek()) == isPositive(asteroid)) {
                currentState.push(asteroid);
            } else {
                while(!currentState.isEmpty() && currentState.peek()>=0 && currentState.peek()<Math.abs(asteroid)) {
                    currentState.pop();
                }
                if (currentState.isEmpty()) {
                    currentState.push(asteroid);
                } else if (currentState.peek() == Math.abs(asteroid)) {
                    currentState.pop();
                } else if (currentState.peek()<0) {
                    currentState.push(asteroid);
                }
            }
        }
        int result[] = new int[currentState.size()];
        for(int i=result.length-1; i>=0; i--) {
            result[i] = currentState.pop();
        }
        return result;
    }
    public boolean isPositive(int n) {
        return n >= 0;
    }
}