class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> visited = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            int pair = target - nums[i];
            if (visited.containsKey(pair)) {
                return new int[]{visited.get(pair), i};
            } else if(!visited.containsKey(nums[i])) {
                visited.put(nums[i], i);
            }
        }
        return new int[]{0,0};
    }
}
