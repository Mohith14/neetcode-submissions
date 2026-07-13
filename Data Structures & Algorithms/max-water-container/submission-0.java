class Solution {
    public int maxArea(int[] heights) {
        int best = 0;

        int i = 0;

        int j = heights.length - 1;

        while(i < j ){
            int h = Math.min(heights[i] , heights[j]);
            int area = h * (j - i);

            best = Math.max(area, best);

            if( heights[i] < heights[j]){
                i++;
            }else{
                j--;
            }
        }
        return best;
    }
}
