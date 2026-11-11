class Solution {
    public int minEatingSpeed(int[] piles, int h) {
     int least =1;
     int max =0;
     for(int i=0; i< piles.length;i++){
        max = Math.max(max, piles[i]);
     }

     //we ahve least 1 not od banans can eat and max no of banams it can eat so the answer is in b/w least and max 

     //i use binary search to find the speed of the banans 

     while(least < max){
        int mid = least + (max - least)/2;

        if(hours(piles,mid) <=h ){
            max= mid;
        }else{
            least = mid + 1;
        }
     }
     return least;
    }
    //heleper methdo to calculate hours 
    public int hours(int []piles, int speed){
        int hours =0;
        for(int p : piles){
            hours+= (p + speed - 1 )/speed;
        }
        return hours;
    }
}
