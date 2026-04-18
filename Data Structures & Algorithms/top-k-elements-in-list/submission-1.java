class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numFreq = new HashMap<>();
        for (int num: nums) {
            int count = numFreq.getOrDefault(num, 0);
            count++;
            numFreq.put(num, count);
        }
        PriorityQueue<Pair<Integer, Integer>> minHeap = new PriorityQueue<>(
            new Comparator<Pair<Integer, Integer>>() {
                public int compare(Pair<Integer, Integer> a1, Pair<Integer, Integer> a2) {
                    return a1.getValue().compareTo(a2.getValue());
                }
            }
        );
        numFreq.forEach((key, val) -> {
            minHeap.add(new Pair(key, val));
            if (minHeap.size()>k) {
                minHeap.poll();
            }
        });
        int result[] = new int[k];
        for(int i=0; i<k;i++) {
            result[i] = minHeap.poll().getKey();
        }
        return result;
    }
    class Pair<K, V> {
        private K key;
        private V value;
        
        public Pair(K key, V value)
        {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return this.key;
        }
        public V getValue() {
            return this.value;
        }
    }
}
