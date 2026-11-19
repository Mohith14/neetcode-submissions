class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int row = grid.length;
        int col= grid[0].length;
        int maxArea =0;

        for(int i =0; i<row;i++){
            for(int j =0; j<col;j++){
                if(grid[i][j]==1){
                    maxArea = Math.max(bfs(grid,i,j),maxArea);
                }
            }
        }
        return maxArea;
    }
    public int bfs(int[][] grid, int row,int col){
        Queue<int[]> q = new LinkedList<>();
        int count=1;
        q.add(new int[]{row,col});
        grid[row][col]=0;
        while(!q.isEmpty()){
            int[] cell = q.poll();
            int[][] dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
            for(int[] d: dir){
                int r = cell[0] + d[0];
                int c= cell[1]+d[1];

                if(r >=0 && r<grid.length&& c>=0&& c<grid[0].length && grid[r][c]==1){
                    q.add(new int[]{r,c});
                    grid[r][c]=0;
                    count++;
                }
            }
        }
    return count;
    }
}
