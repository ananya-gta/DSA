class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0, n = s.length(), max = 0;
        Set<Character> set = new HashSet<>();
        for (int j = 0; j < n; j++) {
            char currCh = s.charAt(j);
            
            while (set.contains(currCh)) {
                char chAtStartOfWindow = s.charAt(i);
                set.remove(chAtStartOfWindow);
                i++;
            }
            set.add(currCh);
            max = Math.max(max, j - i + 1);
        }
        return max;
    }
}