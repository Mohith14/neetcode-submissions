class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int n : nums){
            set.add(n);
        }
        int longest =0;
        for(int n : nums){
            if(!set.contains(n-1)){
                int current = n;
                int streak = 1;

                while(set.contains(current+1)){
                    current = current +1;
                    streak = streak + 1;
                }
                longest = Math.max(streak, longest);
            }
        }
        return longest;
    }
}
