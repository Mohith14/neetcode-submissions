class Solution {
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int count =0;

        for(int i =0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j] == '1'){
                    count++;
                    bfs(grid, i, j);
                }
            }
        }
        return count;
    }
    public void bfs(char[][] grid, int row, int col){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {row, col});
        grid[row][col] = '0';

        while(!q.isEmpty()){
            int [] cell = q.poll();
            int r = cell[0];
            int c = cell[1];

            int[][] dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

            for(int[] d : dir){
                int r1 = r+d[0];
                int c1=c+d[1];

              if( r1>=0 && r1<grid.length && c1>=0 && c1<grid[0].length && grid[r1][c1] =='1'){
                    q.add(new int[]{r1,c1});
                    grid[r1][c1] ='0';
                }
            }
        }
    }
}
