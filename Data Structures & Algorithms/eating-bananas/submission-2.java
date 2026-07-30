class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l =1;
        int h1=0;
        for(int p : piles){
            h1 = Math.max(h1 , p);
        }
        while(l < h1){
            int mid = l + (h1 -l)/2;

            if(hoursNeeded(piles , mid) <= h){
                h1 =mid;
            }else{
                l = mid + 1;
            }
        }
        return l;
    }
    private long hoursNeeded(int [] piles, int k){
        long hours =0;
        for(int p : piles){
            hours+=(p + k - 1)/k;
        }
        return hours;
    }
}
