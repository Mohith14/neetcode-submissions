class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> ch = new HashSet<>();
        int r=0;
        int l =0;
        int len =0;
        for(char c: s.toCharArray()){
            while(ch.contains(c)){
                ch.remove(s.charAt(l));
                l++;
            }
            ch.add(c);
            len = Math.max(len, (r - l) + 1);
            r++;
        }
        return len;
    }
}
