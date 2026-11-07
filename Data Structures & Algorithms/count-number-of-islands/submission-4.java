class Solution {
    public int numIslands(char[][] grid) {

        //given a groid with 0;s and 1's when I encounter 1 it is consider as island nad connected hor and ver are consider as one island?

        //in the q mentined hor and ver does daigonal also considered as ? idsland ?
        //can I modifyn the grid ?
        int count =0;
        int row = grid.length;
        int col = grid[0].length;
        //I traverse through each cell and if I encounter 1 i will increase my count and 
        for(int i =0; i<row;i++){
            for(int j =0; j<col;j++){
                if(grid[i][j] == '1'){
                    count++;
                    //now i will use bfs to check its neighbours (bfs is like scribble)
                    bfs(grid,i,j);
                }
            }
        }
        return count;
    }
    public void  bfs(char[][] grid, int row, int col){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{row,col});
        //modify grid
        grid[row][col]='0';

        while(!q.isEmpty()){
            int[] temp = q.poll();
            int[][] dir= new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
            for(int[] d: dir){
                int r = temp[0] + d[0];
                int c=temp[1] + d[1];

                if(r>=0 && r<grid.length && c>=0 && c<grid[0].length&& grid[r][c] == '1'){
                    q.add(new int[]{r,c});
                    grid[r][c]='0';
                } 
            }
        }
    }
}
