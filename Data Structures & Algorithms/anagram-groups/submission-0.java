class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<List<Integer>, List<String>> groupedAnag = new HashMap<>();
        for (String str: strs) {
            List<Integer> charOcc = getCharOccurence(str);
            List<String> temp = groupedAnag.getOrDefault(charOcc, new ArrayList<String>());
            temp.add(str);
            groupedAnag.put(charOcc, temp);
        }
        return new ArrayList<>(groupedAnag.values());
    }

    public  List<Integer> getCharOccurence(String s) {
        ArrayList<Integer> result = new ArrayList<Integer>(26);
        for(int i=0; i<26; i++) result.add(0);
        for (char c: s.toCharArray()) {
            int count = result.get((int)(c-'a'));
            count++;
            result.set((int)(c-'a'), count);
        }
        return result;

    }
}
