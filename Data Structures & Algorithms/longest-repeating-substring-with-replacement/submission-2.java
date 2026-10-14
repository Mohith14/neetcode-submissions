class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];

        int i =0; int j=0;
        int freq =0; int res=0;

        for(i =0;i<s.length();i++){
            count[s.charAt(i) - 'A']++;

            freq = Math.max(freq , count[s.charAt(i) - 'A']);

            while((i - j + 1) - freq > k){
                count[s.charAt(j) - 'A']--;
                j++;
            }

            res = Math.max(res, (i-j+1));
        }
        return res;
    }
}
