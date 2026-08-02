class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l =1;
        int r =0;

        for(int p : piles){
            r = Math.max(p, r);
        }

        while(l < r){
            int mid = l + (r -l)/2;

            if(hoursNeeded(piles,mid)<= h){
                r = mid;
            }else{
                l = mid +1;
            }
        }
        return r;
    }
    private long hoursNeeded(int[] piles, int k){
        long hours =0;

        for(int p : piles){
            hours += (p + k -1)/k;
        }
        return hours;
    }
}
