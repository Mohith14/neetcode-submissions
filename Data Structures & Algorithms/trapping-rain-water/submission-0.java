class Solution {
    public int trap(int[] height) {
        int l = 0;
        int r= height.length -1;
        int lmax =0;
        int rmax = 0;
        int total =0;

        while(l < r){
            if(height[l] < height[r]){
                lmax = Math.max(lmax, height[l]);
                total += lmax - height[l];
                l++;
            }else{
                rmax = Math.max(rmax, height[r]);
                total += rmax - height[r];
                r--;
            }
        }
        return total;
    }
}
