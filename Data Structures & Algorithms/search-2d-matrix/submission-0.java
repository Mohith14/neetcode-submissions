class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n= matrix[0].length;
        int left =0;
        int right = (m*n) -1;

        while(left <= right){
            int mid = left + (right - left) /2;
            int c = mid%n;
            int row = mid/n;
            int val = matrix[row][c];
            if(val == target){
                return true;
            }else if(val < target){
                left++;
            }else{
                right--;
            }
        }
        return false;
    }
}
