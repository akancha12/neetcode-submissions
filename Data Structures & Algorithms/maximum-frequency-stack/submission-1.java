class FreqStack {
    int idx;
    Map<Integer, Integer> numToFreq;
    PriorityQueue<Integer> maxFreqHeap;
    Map<Integer, Integer> idxToNumMap;
    Map<Integer, Stack> freqToIdxMap;
    public FreqStack() {
        idx = -1;
        numToFreq = new HashMap<>();
        maxFreqHeap = new PriorityQueue(Collections.reverseOrder());
        idxToNumMap = new HashMap<>();
        freqToIdxMap = new HashMap<>();
    }

    public void push(int val) {
        idx++;
        int currFreq = numToFreq.getOrDefault(val, 0);
        int newFreq = currFreq + 1;
        numToFreq.put(val, newFreq);
        maxFreqHeap.remove(currFreq);
        maxFreqHeap.add(newFreq);
        idxToNumMap.put(idx, val);
        Stack<Integer> stack = freqToIdxMap.getOrDefault(newFreq, new Stack<Integer>());
        stack.push(idx);
        freqToIdxMap.put(newFreq, stack);
    }

    public int pop() {
        int highestFreq = maxFreqHeap.poll();
        Stack<Integer> stack = freqToIdxMap.get(highestFreq);
        int idxToPop = stack.pop();
        freqToIdxMap.put(highestFreq, stack);
        int result = idxToNumMap.get(idxToPop);
        if (highestFreq > 1)
            maxFreqHeap.add(highestFreq - 1);
        numToFreq.put(result, highestFreq - 1);
        return result;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */