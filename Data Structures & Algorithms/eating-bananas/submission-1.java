class Solution {
    public int minEatingSpeed(int[] piles, int h1) {
        int l =1;
        int h=0;
        for(int p : piles){
            h = Math.max(h ,p);
        }
        while(l < h){
            int mid = l + (h - l)/2;
            if(hoursNeeded(piles, mid) <=h1){
                h = mid;
            }else{
                l =  mid +1;
            }
        }
        return l;
    }
    private long hoursNeeded(int [] piles, int k){
        long hours =0;
        for( int p : piles){
            hours+= (p + k - 1)/k;
        }
        return hours;
    }
}
