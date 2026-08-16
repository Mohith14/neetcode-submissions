class Solution {
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int noOfIslands =0;

        for(int i =0; i< row; i++){
            for(int j=0; j<col; j++){
                if(grid[i][j] == '1'){
                   noOfIslands++;
                   sink(grid, i , j); 
                }
            }
        }
        return noOfIslands;
    }
    public void sink(char [][] grid, int r, int c){

        if(r < 0 || r >= grid.length ||  c < 0 || c>=grid[0].length || grid[r][c] == '0'){
            return;
        }
        grid[r][c] ='0';

        sink(grid, r+1 , c); //down
        sink(grid, r-1 , c); //up
        sink(grid, r , c+1);//right
        sink(grid, r, c-1);//left

    }
}
