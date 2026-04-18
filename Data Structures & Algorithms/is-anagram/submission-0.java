class Solution {
    public boolean isAnagram(String s, String t) {
        int[] charOccurence1 = getCharOccurence(s);
        int[] charOccurence2 = getCharOccurence(t);

        for(int i=0; i<26; i++) {
            if(charOccurence1[i]!=charOccurence2[i]) {
                return false;
            }
        }
        return true;
    }
    public int[] getCharOccurence(String s) {
        int result[] = new int[26];
        for (char c: s.toCharArray()) {
            result[(int)(c-'a')]++;
        }
        return result;
    }
}
