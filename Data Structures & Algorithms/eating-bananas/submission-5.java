class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int least = 1;
        int max= 0;

        for(int p: piles){
            max = Math.max(p,max);
        }

        while(least < max){
            int  mid = least + (max - least)/2;

            if(speedCheck(piles,mid) <=h){
                max = mid;
            }else{
                least = mid + 1;
            }
        }
        return least;

    }
    public int speedCheck(int [] piles, int k){

        int hours =0;
        for(int p : piles){
            hours+= (p + k -1) /k;
        }
        return hours;
    }
}
